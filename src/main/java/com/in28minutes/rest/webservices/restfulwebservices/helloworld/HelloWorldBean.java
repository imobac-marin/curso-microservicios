package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

/**
 * The Class HelloWorldBean.
 */
public class HelloWorldBean {

	/** The message. */
	private String message;

	/**
	 * Instantiates a new hello world bean.
	 *
	 * @param message the message
	 */
	public HelloWorldBean(String message) {
		this.message = message;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", message);
	}

}
