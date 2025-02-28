package dev.pustelnikov;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args) {

        // Creating of devices
        HomeDevice ceilingChandelier = new HomeDevice("Ceiling Chandelier", 300, false);
        HomeDevice computer = new HomeDevice("Computer", 100, false);
        HomeDevice fridge = new HomeDevice("Fridge", 200, false);
        HomeDevice kettle = new HomeDevice("Kettle", 1500, false);
        HomeDevice microwave = new HomeDevice("Microwave", 2000, false);
        HomeDevice tableLamp = new HomeDevice("Table lamp", 10, false);
        HomeDevice tv = new HomeDevice("TV", 150, false);

        // Creating of services
        HomeDeviceService service = new HomeDeviceService();

        // Adding devices to a collection for operations
        List<HomeDevice> devices = new ArrayList<>();
        devices.add(ceilingChandelier);
        devices.add(computer);
        devices.add(fridge);
        devices.add(kettle);
        devices.add(microwave);
        devices.add(tableLamp);
        devices.add(tv);

        // Sorting devices by power
        service.sortByPower(devices);

        // Filtering devices by power range
        List<HomeDevice> filteredByPowerRangeDevices = service
                .filterByPowerRange(devices, 150, 1500);

        // Displaying the sorting result
        System.out.println("All devices (sorted by power)");
        devices.forEach(d -> System.out.println(d.toString()));
        System.out.println('\n');

        // Displaying the filtering result
        System.out.println("Filtered devices (by power range)");
        filteredByPowerRangeDevices.forEach(d -> System.out.println(d.toString()));
        System.out.println('\n');

        // Switching on of some devices
        computer.setStatus(true);
        fridge.setStatus(true);
        tableLamp.setStatus(true);
        tv.setStatus(true);

        // Displaying the switched on devices
        System.out.println("Switched on devices");
        service.showSwitchedOnDevices(devices);
        System.out.println('\n');

        // Calculation of the total power consumption of the switched on devices
        int sumPowerOfTurnedOnDevices = service.calculatePowerOfTurnedOnDevices(devices);

        // Displaying the total power consumption result
        System.out.println("Total power consumption of switched on devices, Watt: "
                + sumPowerOfTurnedOnDevices);
    }
}
