package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The Class User.
 */
@ApiModel(description = "Detalles sobre el usuario.")
@Entity
public class User {

	/** The id. */
	@Id
	@GeneratedValue
	private Integer id;

	/** The name. */
	@Size(min = 2, message = "El nombre debe tener al menos 2 letras.")
	@ApiModelProperty(notes = "El nombre debe tener al menos 2 letras.")
	private String name;

	/** The birth date. */
	@Past
	@ApiModelProperty(notes = "La fecha debe ser antes de la fecha actual")
	private Date birthDate;

	/** The posts. */
	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	/**
	 * Instantiates a new user.
	 */
	protected User() {
	};

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Gets the posts.
	 *
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * Sets the posts.
	 *
	 * @param posts the new posts
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id the id
	 * @param name the name
	 * @param birthDate the birth date
	 */
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
}
