package com.vehicles.project.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

public class TestVehicle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Wheel> frontWheels = new ArrayList<>();
    static List<Wheel> backWheels = new ArrayList<>();

    public static void main(String[] args) throws Exception {
	Vehicle vehicle = inputCreateVehicle();
	System.out.println(vehicle.toString());
    }

    private static Vehicle inputCreateVehicle() throws Exception {
	Vehicle vehicle = null;
	boolean exit = false;
	int num;
	do {
	    printVehicle();
	    num = Integer.parseInt(br.readLine());
	    switch (num) {
	    case 1:
		vehicle = inputCreateCar();
		inputCreateCarWheels(vehicle);
		exit = true;
		break;
	    case 2:
		vehicle = inputCreateBike();
		inputCreateBikeWheels(vehicle);
		exit = true;
		break;
	    default:
		System.out.println("ERROR");
		exit = false;
		break;
	    }

	} while (!exit);
	return vehicle;
    }

    private static void inputCreateCarWheels(Vehicle vehicle) throws Exception {

	Wheel leftWheel, rightWheel;
	System.out.println("\nCreate front wheels");
	leftWheel = inputCreateWheel();
	rightWheel = inputCreateWheel();
	frontWheels = ((Car) vehicle).addWheelsCar(leftWheel, rightWheel);
	System.out.println("\nCreate back wheels");
	leftWheel = inputCreateWheel();
	rightWheel = inputCreateWheel();
	backWheels = ((Car) vehicle).addWheelsCar(leftWheel, rightWheel);
    }

    private static void inputCreateBikeWheels(Vehicle vehicle) throws Exception {
	Wheel front, back;
	System.out.println("\nCreate front wheel");
	front = inputCreateWheel();
	frontWheels = ((Bike) vehicle).addWheelBike(front);
	System.out.println("\nCreate back wheel");
	back = inputCreateWheel();
	backWheels = ((Bike) vehicle).addWheelBike(back);
	vehicle.addWheels(frontWheels, backWheels);
    }

    private static Wheel inputCreateWheel() throws Exception {
	System.out.println("--Wheel BRAND--");
	String brand = br.readLine();
	System.out.println("--Wheel DIAMETER--");
	double diameter = Double.parseDouble(br.readLine());
	Wheel.checkDiameter(diameter);
	Wheel wheel = new Wheel(brand, diameter);
	return wheel;
    }

    private static Car inputCreateCar() throws Exception {
	System.out.println("--PLATE--");
	String plate = br.readLine();
	Vehicle.checkPlate(plate);
	System.out.println("--BRAND--");
	String brand = br.readLine();
	System.out.println("--COLOR--");
	String color = br.readLine();
	Car car = new Car(plate, brand, color);
	return car;
    }

    private static Bike inputCreateBike() throws Exception {
	System.out.println("--PLATE--");
	String plate = br.readLine();
	Vehicle.checkPlate(plate);
	System.out.println("--BRAND--");
	String brand = br.readLine();
	System.out.println("--COLOR--");
	String color = br.readLine();
	Bike bike = new Bike(plate, brand, color);
	return bike;
    }

    private static void printVehicle() {
	System.out.println("[1] Create CAR");
	System.out.println("[2] Create BIKE");
	System.out.println("[0] EXIT");
    }
}
