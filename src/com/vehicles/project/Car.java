package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	@Override
	public void addWheelsAxis(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception("IT HAS TO BE TWO WHEELS");

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception("THE WHEELS OF THE SAME AXIS SHOULD BE EQUAL");

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}

	public List<Wheel> addWheelsCar(Wheel leftWheel, Wheel rightWheel) {
		List<Wheel> wheels = new ArrayList<>();
		wheels.add(leftWheel);
		wheels.add(rightWheel);
		return wheels;
	}

	@Override
	public String toString() {
		return "Car [ " + super.toString() + " ]";
	}

}
