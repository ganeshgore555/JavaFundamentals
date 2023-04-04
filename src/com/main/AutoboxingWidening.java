package com.main;

public class AutoboxingWidening {

	public static void main(String[] args) {
		int i = 10;
		printNumber(i);
		
		Integer iWrapper = 20;
		printNumber(iWrapper);
		
		long l = 30;
		printNumber(l);		
		
		Long lWrapper = 40l;
		printNumber(lWrapper);
		
		
		double d = 50;
		//printNumber(d);		
		printDouble(d);
		
		Double dWrapper = 60.0;
		//printNumber(dWrapper);
		printDouble(dWrapper);
		
		printDouble(i);
		printDouble(iWrapper);
		printDouble(l);
		printDouble(lWrapper);
	}

	public static void printNumber(Integer i) {
		System.out.println("Integer : " + i);
	}
	
	public static void printNumber(long i) {
		System.out.println("long : " + i);
	}
	
	public static void printNumber(int i) {
		System.out.println("int : " + i);
	}
	
	public static void printDouble(double d) {
		System.out.println("double : " + d);
	}
	
	public static void printDouble(Double d) {
		System.out.println("Double : " + d);
	}
}
