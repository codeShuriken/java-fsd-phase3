package com.example.Authentication.exceptions;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(int id){
		super("Could not find employee with id: " + id);
	}
	
}
