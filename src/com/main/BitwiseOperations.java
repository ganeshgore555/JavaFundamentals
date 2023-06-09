package com.main;

public class BitwiseOperations {

	public static void main(String[] args) {
		System.out.println(5^4^17^4^5);
		int mask = 2;
		System.out.print(Integer.toBinaryString(mask | (1 << 3)));
	}

}
