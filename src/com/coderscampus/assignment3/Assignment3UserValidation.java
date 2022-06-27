package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment3UserValidation {
	public static User[] users = new User[5]; 
	private static UserService userService = new UserService();

	public static void main(String[] args) throws IOException {
		userArray();
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			
			boolean validLogin = false;
			int loginAttempts = 0;
			while (!validLogin && loginAttempts < 5) {
				System.out.println("Enter your email: ");
				String username = scanner.nextLine();
				System.out.println("Enter your password: ");
				String password = scanner.nextLine();

				User validUser = userService.validateUser(username, password);
				if (validUser != null) {
					System.out.println("Welcome: " + validUser.getName());
					validLogin = true;
				} else {
					System.out.println("Invalid login, please try again");
					loginAttempts++;
					if (loginAttempts == 5) {
						System.out.println("Too many failed login attempts, you are now locked out.");
					}
				}
			}
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	private static void userArray() throws IOException {

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
	}
}
