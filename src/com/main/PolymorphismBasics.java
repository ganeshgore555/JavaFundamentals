package com.main;

public class PolymorphismBasics {
	
	public static void main(String[] args) {
		InterfaceDrive drive = new Car();
		System.out.println(drive.X);
		//drive.X = "Drive_X_var_v1";
		System.out.println(drive.Y);
		System.out.println(drive.Z);
		drive.drive();
		drive.race();
		//drive.start();
		//drive.stop();
		System.out.println("--------------------");
		
		AbstractVehicle vehicle = new Car();
		//vehicle.X = "Vehicle_X_var_v1";
		System.out.println(vehicle.X);
		System.out.println(vehicle.Z);
		vehicle.drive();
		vehicle.race();
		vehicle.start();
		vehicle.stop();

		System.out.println("--------------------");
		
		Car car = new Car();
		System.out.println(car.X);
		System.out.println(car.Y);
		System.out.println(car.Z);
		car.drift();
		car.drive();
		car.race();
		car.start();
		car.stop();

	}
}

