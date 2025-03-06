package dev.pustelnikov.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class DataSource {

	private static DataSource instance;
    private final ComboPooledDataSource dataSource;
	
	private DataSource() {
        Properties properties = new Properties();
		dataSource = new ComboPooledDataSource();
		try (InputStream input = Thread
				.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("db.properties")) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Class.forName(properties.getProperty("db.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl(properties.getProperty("db.url"));
		dataSource.setUser(properties.getProperty("db.user"));
		dataSource.setPassword(properties.getProperty("db.password"));
	}
	
	public static DataSource getInstance() {
		if (instance == null) {
			instance = new DataSource();
		}
	return instance;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
