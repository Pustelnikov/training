package dev.pustelnikov.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HomeDevice {
	private Long id;
	private String description;
	private Integer power;
	private Boolean status;
}
