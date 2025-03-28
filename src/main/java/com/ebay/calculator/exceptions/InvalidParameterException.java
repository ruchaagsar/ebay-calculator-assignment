package com.ebay.calculator.exceptions;

import lombok.Data;

@Data
public class InvalidParameterException extends RuntimeException {
	public InvalidParameterException(String message) {
		super(message);
	}
	public InvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}
	public InvalidParameterException(Throwable cause) {
		super(cause);
	}
}
