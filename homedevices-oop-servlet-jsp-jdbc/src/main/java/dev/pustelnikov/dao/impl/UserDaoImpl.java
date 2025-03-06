package dev.pustelnikov.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dev.pustelnikov.datasource.DataSource;
import dev.pustelnikov.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean isUserSignedUp(String username, String password) {
		try {
			Connection connection = DataSource.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement
					("""
							SELECT * FROM "user"
							WHERE username = ? AND password = ?
					""");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
