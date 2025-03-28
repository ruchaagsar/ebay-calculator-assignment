package com.ebay.calculator.exceptions;

import com.ebay.calculator.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidParameterException.class)
	public ResponseEntity<Response<String>> handleBadParameterException(InvalidParameterException ex) {
		Response<String> response = new Response<>(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OperationException.class)
	public ResponseEntity<Response<String>> handleCalculationException(OperationException ex) {

		if (ex.getCause() instanceof ArithmeticException) {
			return handleArithmeticException(ex.getCause());
		}

		Response<String> response = new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		String message = ex.getMessage() != null ? ex.getMessage() : "An error occurred";
		Response<String> response = new Response<>(HttpStatus.BAD_REQUEST.toString(), message, null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response<String>> handleGeneralException(Exception ex) {
		String message = ex.getMessage() != null ? ex.getMessage() : "An error occurred";
		Response<String> response = new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), message, null);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Response<String>> handleArithmeticException(Throwable throwable) {
		String message = throwable.getMessage() != null ? throwable.getMessage() : "An arithmetic error occurred";
		Response<String> response = new Response<>(HttpStatus.BAD_REQUEST.toString(), message, null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
