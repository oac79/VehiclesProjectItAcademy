package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    protected String plate;
    protected String brand;
    protected String color;
    protected List<Wheel> wheels = new ArrayList<Wheel>();

    public Vehicle(String plate, String brand, String color) {
	this.plate = plate;
	this.brand = brand;
	this.color = color;
    }

    // FASE 2
    public static boolean checkPlate(String plate) throws Exception {
	if (plate.toUpperCase().matches("[0-9]{4}[A-Z]{2,3}")) {
	    return true;
	} else {
	    throw new Exception("ERROR Plate");
	}
    }

    @Override
    public String toString() {
	return "Vehicle [plate=" + plate + ", brand=" + brand + ", color=" + color + wheels.toString() + "]";
    }

    public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
	addWheelsAxis(frontWheels);
	addWheelsAxis(backWheels);
    }

    // FASE 3
    /*
     * Método abstracto obliga a implementar este método a las claese que hereden de
     * Vehicle
     */
    // Ejemplo claro de polimorfísmo ya que las clases que implementen el método lo
    // van a sobreescribir
    public abstract void addWheelsAxis(List<Wheel> wheels) throws Exception;

}
