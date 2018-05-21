package com.in28minutes.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * The Class UserJPAController.
 */
@RestController
public class UserJPAController {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/** The post repository. */
	@Autowired
	private PostRepository postRepository;

	/**
	 * Retrieve all users.
	 *
	 * @return the list
	 */
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * Retrieve user.
	 *
	 * @param id the id
	 * @return the resource
	 */
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		resource.add(linkTo.withRel("all-users"));

		return resource;
	}

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * Delete user.
	 *
	 * @param id the id
	 */
	@DeleteMapping("/jpa/users/{id}")
	public void DeleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	
	//Métodos para la parte de los posts del usuario.
	
	/**
	 * Retrieve all user posts.
	 *
	 * @param id the id
	 * @return the list
	 */
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUserPosts(@PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		return userOptional.get().getPosts();
	}
	
	/**
	 * Creates the post.
	 *
	 * @param id the id
	 * @param post the post
	 * @return the response entity
	 */
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		User user = userOptional.get();
		
		post.setUser(user);
		postRepository.save(post);
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
