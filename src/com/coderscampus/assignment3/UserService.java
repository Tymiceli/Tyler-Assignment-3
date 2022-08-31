package com.coderscampus.assignment3;

import java.io.IOException;

public class UserService {
	
	public User validateUser(String username, String password) throws IOException {
		UserArrayService userArrayService = new UserArrayService();
		for (User user : userArrayService.getUserArray()) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

}
