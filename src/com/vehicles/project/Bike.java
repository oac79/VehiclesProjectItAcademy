package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	// FASE 3
	@Override
	public void addWheelsAxis(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 1)
			throw new Exception("IT SHOULD BE A WHEEL");
		Wheel wheel = wheels.get(0);
		this.wheels.add(wheel);
	}

	public List<Wheel> addWheelBike(Wheel wheel) {
		List<Wheel> wheels = new ArrayList<>();
		wheels.add(wheel);
		return wheels;
	}

	@Override
	public String toString() {
		return "Bike [" + super.toString() + " ]";
	}

}
