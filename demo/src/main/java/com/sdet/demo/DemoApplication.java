package com.sdet.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
	private List<String> availableTimeSlot = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void initialize() {
		// Load your initial data or perform tasks here
		availableTimeSlot.add("10:15AM");
		availableTimeSlot.add("11:15AM");
		availableTimeSlot.add("12:15PM");

		System.out.println("Initialized availableTimeSlot: " + availableTimeSlot);
	}
}
