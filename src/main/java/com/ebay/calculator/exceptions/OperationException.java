package com.ebay.calculator.exceptions;

import lombok.Data;

@Data
public class OperationException extends RuntimeException{
	public OperationException(String message) {
		super(message);
	}
	public OperationException(String message, Throwable cause) {
		super(message, cause);
	}
	public OperationException(Throwable cause) {
		super(cause);
	}
}
