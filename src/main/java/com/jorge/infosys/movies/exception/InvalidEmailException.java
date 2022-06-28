package com.jorge.infosys.movies.exception;

public class InvalidEmailException extends InfyMovieMaxException {
	private static final long serialVersionUID = 1L;

	public InvalidEmailException(String message) {
		super(message);
	}
}
