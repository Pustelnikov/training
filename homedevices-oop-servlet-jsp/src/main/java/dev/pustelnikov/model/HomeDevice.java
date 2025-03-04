package dev.pustelnikov.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HomeDevice {
	private String description;
	private int power;
	private boolean status;
}
