package com.asyraf.example.usecase.exception;

public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException(final String email) {
		super(email);
	}
}
