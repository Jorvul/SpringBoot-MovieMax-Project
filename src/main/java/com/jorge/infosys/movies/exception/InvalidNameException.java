package com.jorge.infosys.movies.exception;

public class InvalidNameException extends InfyMovieMaxException{
		private static final long serialVersionUID = 1L;
		
		public InvalidNameException(String message) {
			super(message);
		}

}
