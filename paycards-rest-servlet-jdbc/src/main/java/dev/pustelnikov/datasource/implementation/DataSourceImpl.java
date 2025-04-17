package dev.pustelnikov.datasource.implementation;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public final class DataSourceImpl implements DataSource {
	private static DataSourceImpl instance;
    private final ComboPooledDataSource dataSource;
	
	private DataSourceImpl() {
        Properties properties = new Properties();
		dataSource = new ComboPooledDataSource();
		try (InputStream input = Thread
				.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("datasource.properties")) {
			properties.load(input);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			Class.forName(properties.getProperty("datasource.driver"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		dataSource.setJdbcUrl(properties.getProperty("datasource.url"));
		dataSource.setUser(properties.getProperty("datasource.user"));
		dataSource.setPassword(properties.getProperty("datasource.password"));
	}
	
	public static DataSourceImpl getInstance() {
		if (instance == null) {
			instance = new DataSourceImpl();
		}
	return instance;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}
}
