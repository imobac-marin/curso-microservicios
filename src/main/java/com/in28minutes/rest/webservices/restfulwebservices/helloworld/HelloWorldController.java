package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	//GET
	//URI - /helo-world
	//method - "Hello World"
	@GetMapping(path="/hello-world")
	public String helloWorld(){
		return "Hello World";
	}
	
	//hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}
	
	// /hello-world/path-variable/in28minutes
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale){
		return messageSource.getMessage("good.morning.message", null, locale);
	}
}
