package dev.pustelnikov.service;

import java.util.ArrayList;
import java.util.List;
import dev.pustelnikov.model.User;

public class AuthenticationService {

	private final List<User> users;
	
	public AuthenticationService() {
		users = new ArrayList<>();
		User admin = new User("admin", "admin");
		User user = new User("user", "user");
		users.add(admin);
		users.add(user);
	}
	
	public boolean checkCredentials(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
