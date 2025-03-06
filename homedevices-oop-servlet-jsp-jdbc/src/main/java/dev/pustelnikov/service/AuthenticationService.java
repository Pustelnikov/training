package dev.pustelnikov.service;

import dev.pustelnikov.dao.UserDao;
import dev.pustelnikov.dao.impl.UserDaoImpl;

public class AuthenticationService {
	
	public boolean checkCredentials(String username, String password) {
		UserDao dao = new UserDaoImpl();
		return dao.isUserSignedUp(username, password);
	}
}
