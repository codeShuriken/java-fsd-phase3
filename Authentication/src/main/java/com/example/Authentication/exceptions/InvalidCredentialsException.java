package com.example.Authentication.exceptions;

public class InvalidCredentialsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException() {
		super("INVALID Login Credentials!!! Please Try Again!");
	}
}
