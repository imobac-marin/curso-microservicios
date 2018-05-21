package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * The Class UserDaoService.
 */
@Component
public class UserDaoService {
	
	/** The users. */
	private static List<User> users = new ArrayList<>();
	
	/** The users count. */
	private static int usersCount = 3;
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<User> findAll() {
		return users;
	}

	/**
	 * Save.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
