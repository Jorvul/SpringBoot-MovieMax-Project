package com.jorge.infosys.movies.exception;

public class UserIdAlreadyPresentException extends InfyMovieMaxException {
	private static final long serialVersionUID = 1L;
	
	public UserIdAlreadyPresentException(String message) {
		super(message);
	}

}
