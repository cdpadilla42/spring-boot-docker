package com.example.demo;

public class BookIdMismatchException extends RuntimeException {
	public BookIdMismatchException(String message, Throwable cause) {
		super(message, cause);
	}
}
