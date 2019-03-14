package userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

public class TestVehicle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		List<Wheel> frontWheels = new ArrayList<>();
		List<Wheel> backWheels = new ArrayList<>();
		Vehicle vehicle = inputCreateVehicle();
		if (vehicle instanceof Car) {
			Wheel leftWheel, rightWheel;
			System.out.println("\nCreate front wheels");
			leftWheel = inputCreateWheel();
			rightWheel = inputCreateWheel();
			frontWheels = ((Car) vehicle).addWheelsCar(leftWheel, rightWheel);
			System.out.println("\nCreate back wheels");
			leftWheel = inputCreateWheel();
			rightWheel = inputCreateWheel();
			backWheels = ((Car) vehicle).addWheelsCar(leftWheel, rightWheel);
			vehicle.addWheels(frontWheels, backWheels);
		} else if (vehicle instanceof Bike) {
			Wheel front, back;
			System.out.println("\nCreate front wheel");
			front = inputCreateWheel();
			frontWheels = ((Bike) vehicle).addWheelBike(front);
			System.out.println("\nCreate back wheel");
			back = inputCreateWheel();
			backWheels = ((Bike) vehicle).addWheelBike(back);
			vehicle.addWheels(frontWheels, backWheels);
		} else {
			System.err.println("Error Vehicle");
		}
		System.out.println(vehicle.toString());
	}

	private static Vehicle inputCreateVehicle() throws IOException {
		Vehicle vehicle = null;
		boolean salir = false;
		int num;
		do {
			printVehicle();
			num = Integer.parseInt(br.readLine());
			switch (num) {
			case 1:
				vehicle = inputCreateCar();
				salir = true;
				break;
			case 2:
				vehicle = inputCreateBike();
				salir = true;
				break;
			default:
				System.out.println("ERROR");
				salir = false;
				break;
			}
		} while (!salir);

		return vehicle;
	}

	private static Wheel inputCreateWheel() throws IOException {
		System.out.println("--Wheel BRAND--");
		String brand = br.readLine();
		System.out.println("--Wheel DIAMETER--");
		double diameter = Double.parseDouble(br.readLine());
		if (!Wheel.checkDiameter(diameter)) {
			System.err.println("ERROR DIAMETER");
		}
		Wheel wheel = new Wheel(brand, diameter);
		return wheel;
	}

	private static Car inputCreateCar() throws IOException {
		System.out.println("--PLATE--");
		String plate = br.readLine();
		if (!Vehicle.checkPlate(plate)) {
			System.out.println("Error Input PLATE");
		}
		System.out.println("--BRAND--");
		String brand = br.readLine();
		System.out.println("--COLOR--");
		String color = br.readLine();
		Car car = new Car(plate, brand, color);
		return car;
	}

	private static Bike inputCreateBike() throws IOException {
		System.out.println("--PLATE--");
		String plate = br.readLine();
		if (!Vehicle.checkPlate(plate)) {
			System.out.println("Error Input PLATE");
		}
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
