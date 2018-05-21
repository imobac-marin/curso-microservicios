package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class HelloWorldController.
 */
//Controller
@RestController
public class HelloWorldController {

	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	//GET
	//URI - /helo-world
	/**
	 * Hello world.
	 *
	 * @return the string
	 */
	//method - "Hello World"
	@GetMapping(path="/hello-world")
	public String helloWorld(){
		return "Hello World";
	}
	
	/**
	 * Hello world bean.
	 *
	 * @return the hello world bean
	 */
	//hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}
	
	/**
	 * Hello world bean.
	 *
	 * @param name the name
	 * @return the hello world bean
	 */
	// /hello-world/path-variable/in28minutes
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	/**
	 * Hello world internationalized.
	 *
	 * @return the string
	 */
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(){
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
