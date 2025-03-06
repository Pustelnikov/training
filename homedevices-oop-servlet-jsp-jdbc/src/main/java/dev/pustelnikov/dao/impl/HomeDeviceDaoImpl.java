package dev.pustelnikov.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dev.pustelnikov.datasource.DataSource;
import dev.pustelnikov.dao.HomeDeviceDao;
import dev.pustelnikov.model.HomeDevice;

public class HomeDeviceDaoImpl implements HomeDeviceDao {

	@Override
	public List<HomeDevice> getDevices() {
		try {
			Connection connection = DataSource.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery
					("""
							SELECT * FROM "home_device"
					""");
			List<HomeDevice> devices = new ArrayList<>();
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String description = resultSet.getString("description");
				Integer power = resultSet.getInt("power");
				Boolean status = false;
				HomeDevice device = new HomeDevice(id, description, power, status);
				devices.add(device);
			}
			return devices;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
