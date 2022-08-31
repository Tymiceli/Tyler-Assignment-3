package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserArrayService {
	
	public User[] getUserArray() throws IOException {
		
		User[] users = new User[4];

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("data.txt"));
			String info;
			int i = 0;
			while ((info = bufferedReader.readLine()) != null) {
				users[i] = new User(info.split(","));
				i = i + 1;
			}
		} finally {
			if (bufferedReader != null) 
				bufferedReader.close();
		}
		return users;
	}
}
