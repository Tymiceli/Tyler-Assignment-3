package com.coderscampus.assignment3;

public class UserService {

	public User validateUser(String username, String password) {
		for (User user : Assignment3UserValidation.users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

}
