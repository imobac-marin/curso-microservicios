package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PersonVersioningController.
 */
@RestController
public class PersonVersioningController {
	
	/**
	 * Person V 1.
	 *
	 * @return the person V 1
	 */
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Pepe Pérez");
	}

	/**
	 * Person V 2.
	 *
	 * @return the person V 2
	 */
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	/**
	 * Param V 1.
	 *
	 * @return the person V 1
	 */
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 paramV1(){
		return new PersonV1("Pepito Partigazo");
	}
	
	/**
	 * Param V 2.
	 *
	 * @return the person V 2
	 */
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramV2(){
		return new PersonV2(new Name("Pepito", "Partigazo"));
	}
	
	/**
	 * Header V 1.
	 *
	 * @return the person V 1
	 */
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1(){
		return new PersonV1("Pepito Partigazo");
	}
	
	/**
	 * Header V 2.
	 *
	 * @return the person V 2
	 */
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2(){
		return new PersonV2(new Name("Pepito", "Partigazo"));
	}
	
	/**
	 * Produces V 1.
	 *
	 * @return the person V 1
	 */
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1(){
		return new PersonV1("Pepito Partigazo");
	}
	
	/**
	 * Produces V 2.
	 *
	 * @return the person V 2
	 */
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2(){
		return new PersonV2(new Name("Pepito", "Partigazo"));
	}

}
