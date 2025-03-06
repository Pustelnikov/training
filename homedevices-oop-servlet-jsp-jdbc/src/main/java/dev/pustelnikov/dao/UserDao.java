package dev.pustelnikov.dao;

public interface UserDao {
	boolean isUserSignedUp(String username, String password);
}
