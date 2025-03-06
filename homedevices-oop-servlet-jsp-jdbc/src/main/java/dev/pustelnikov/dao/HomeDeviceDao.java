package dev.pustelnikov.dao;

import java.util.List;
import dev.pustelnikov.model.HomeDevice;

public interface HomeDeviceDao {
	List<HomeDevice> getDevices();
}
