package com.main;

public abstract class AbstractVehicle implements InterfaceDrive{
	//public String X = "Vehicle_X_var";
	private static String Y = "Vehicle_static_Y_var";
	public String Z = "Vehicle_Z_var";
	protected AbstractVehicle() {
		super();
	}
	public void start() {
		System.out.println("AbstractVehicle::drive" + " X:" + X + " Y:" + Y + " Z:" + Z );
	}
	
	private void drift() {
		System.out.println("AbstractVehicle::drift");
	}
	
	private void drag() {
		System.out.println("AbstractVehicle::drag");
	}
	
	public static void stop() {
		System.out.println("AbstractVehicle::static::stop");
	}
	
	public abstract void drive();
	
}

class Car extends AbstractVehicle implements InterfaceDrive, InterfaceDriveII{
	//public String X = "Car_X_var";
	public static String Y = "Car_static_Y_var";
	protected static String Z = "Car_static_Z_var";
	/*
	public void start() {
		System.out.println("Car::drive" + " X:" + X + " Y:" + Y + " Z:" + Z);
	}
	*/
	public int start(int i) {
		System.out.println("Car::drive(int):int");
		return i;
	}

	protected void drift() {
		System.out.println("Car::drift");
	}
	
	@Override
	public void race() {
		System.out.println("Car::race");
	}
	
	public static void stop() {
		System.out.println("Car::static::stop");
	}

	@Override
	public void drive() {
		System.out.println("Car::drive");
	}
}