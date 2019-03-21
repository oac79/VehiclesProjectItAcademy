package com.vehicles.project;

public class Wheel {
    private String brand;
    private double diameter;

    public Wheel(String brand, double diameter) {
	this.brand = brand;
	this.diameter = diameter;
    }

    // FASE 2
    public static boolean checkDiameter(double diameter) throws Exception {
	if (diameter > 0.4 && diameter < 4) {
	    return true;
	} else {
	    throw new Exception("Error Diamter");
	}
    }

    // FASE 1
    @Override
    public boolean equals(Object obj) {
	if (obj instanceof Wheel) {
	    Wheel wheel = (Wheel) obj;
	    return (this.brand.equals(wheel.brand) && this.diameter == wheel.diameter);
	}
	return false;
    }

    @Override
    public String toString() {
	return "Wheel [brand=" + brand + ", diameter=" + diameter + "]";
    }

}