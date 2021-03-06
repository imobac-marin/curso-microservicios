package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 */
//Configuration
@Configuration
// Enable Swagger
@EnableSwagger2
public class SwaggerConfig {
	
	/** The Constant DEFAULT_CONTACT. */
	public static final Contact DEFAULT_CONTACT = new Contact("Imobac Marín", "https://github.com/imobac-marin", "imomarin@gmail.com");
	
	/** The Constant DEFAULT_API_INFO. */
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Increíble título de la API", "Increíble documentación de la API", "1.0",
			"urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	
	/** The Constant DEFAULT_PRODUCES_AND_CONSUMES. */
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	// Bean - Docket
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
	// Swagger 2
	// All the paths
	// All the apis

}
