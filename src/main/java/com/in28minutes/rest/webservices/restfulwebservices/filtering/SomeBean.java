package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * The Class SomeBean.
 */
@JsonFilter("SomeBeanFilter")
public class SomeBean {

	/** The field 1. */
	private String field1;
	
	/** The field 2. */
	private String field2;
	
	/** The field 3. */
	private String field3;

	/**
	 * Gets the field 1.
	 *
	 * @return the field 1
	 */
	public String getField1() {
		return field1;
	}

	/**
	 * Sets the field 1.
	 *
	 * @param field1 the new field 1
	 */
	public void setField1(String field1) {
		this.field1 = field1;
	}

	/**
	 * Gets the field 2.
	 *
	 * @return the field 2
	 */
	public String getField2() {
		return field2;
	}

	/**
	 * Sets the field 2.
	 *
	 * @param field2 the new field 2
	 */
	public void setField2(String field2) {
		this.field2 = field2;
	}

	/**
	 * Gets the field 3.
	 *
	 * @return the field 3
	 */
	public String getField3() {
		return field3;
	}

	/**
	 * Sets the field 3.
	 *
	 * @param field3 the new field 3
	 */
	public void setField3(String field3) {
		this.field3 = field3;
	}

	/**
	 * Instantiates a new some bean.
	 *
	 * @param field1 the field 1
	 * @param field2 the field 2
	 * @param field3 the field 3
	 */
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
}
