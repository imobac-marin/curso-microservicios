package com.in28minutes.rest.webservices.restfulwebservices.versioning;

/**
 * The Class PersonV2.
 */
public class PersonV2 {
	
	/** The name. */
	private Name name;

	/**
	 * Instantiates a new person V 2.
	 *
	 * @param name the name
	 */
	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Instantiates a new person V 2.
	 */
	public PersonV2(){
		super();
	};
}
