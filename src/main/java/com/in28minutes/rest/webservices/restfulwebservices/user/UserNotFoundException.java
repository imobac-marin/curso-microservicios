package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class UserNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param message the message
	 */
	public UserNotFoundException(String message) {
		super(message);
	}
	

}
