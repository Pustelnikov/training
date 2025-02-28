package dev.pustelnikov;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HomeDevice {
    // Description of device
    private String description;
    // Power consumption
    private int power;
    // Status "On" or "Off"
    private boolean status;
}
