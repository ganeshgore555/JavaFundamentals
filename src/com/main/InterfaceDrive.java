package com.main;

public interface InterfaceDrive {
	public String X = "Drive_X_var";
	public static String Y = "Drive_static_Y_var";
	public static String Z = "Drive_static_Z_var";
	
	default void drive() {
		System.out.println("Drive::drive" + " X:" + X + " Y:" + Y + " Z:" + Z);
	}
	
	public static void driveFast() {
		System.out.println("Drive::driveFast");
	}
	
	void race();
}


interface InterfaceDriveII {
	void race();
}