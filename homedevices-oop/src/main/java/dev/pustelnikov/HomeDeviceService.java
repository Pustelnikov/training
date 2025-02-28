package dev.pustelnikov;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HomeDeviceService {

    public void sortByPower(List<HomeDevice> devices) {
        devices.sort(Comparator.comparing(HomeDevice::getPower));
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
                .filter(HomeDevice::isStatus)
                .mapToInt(HomeDevice::getPower)
                .sum();
    }

    public void showSwitchedOnDevices(List<HomeDevice> devices) {
        devices.stream()
                .filter(HomeDevice::isStatus)
                .forEach(d -> System.out.println(d.toString()));
    }
}
