package dev.pustelnikov.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import dev.pustelnikov.model.HomeDevice;

public class HomeDeviceService {
	
	public List<HomeDevice> sortByPower(List<HomeDevice> devices) {
		return devices.stream()
				.sorted(Comparator.comparing(HomeDevice::getPower))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public List<HomeDevice> filterByPowerRange(List<HomeDevice> devices,
																   int fromPower,
																   int toPower) {
		return devices.stream()
				.filter(d -> d.getPower() >= fromPower && d.getPower() <= toPower)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public int calculatePowerOfTurnedOnDevices(List<HomeDevice> devices) {
		return devices.stream()
				.filter(HomeDevice::getStatus)
				.mapToInt(HomeDevice::getPower)
				.sum();
	}
}
