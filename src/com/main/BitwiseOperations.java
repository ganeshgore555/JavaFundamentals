package com.main;

public class BitwiseOperations {

	public static void main(String[] args) {
		System.out.println(5^4^17^4^5);
		int mask = 2;
		System.out.println(Integer.toBinaryString(mask | (1 << 3)));
		
		System.out.println(1&-1);
		System.out.println(4&-4);
		System.out.println(7&-7);
		System.out.println(Integer.toBinaryString(1) + "-" + Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(7) + "-" + Integer.toBinaryString(-7));
		System.out.println(Integer.toBinaryString(4) + "-" + Integer.toBinaryString(-4));
	}

}
