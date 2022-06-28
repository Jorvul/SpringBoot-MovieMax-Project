package com.jorge.infosys.movies.exception;

public class InvalidUserIdException extends InfyMovieMaxException {

	private static final long serialVersionUID = 1L;
	
	public InvalidUserIdException(String message) {
		super(message);
	}
}
