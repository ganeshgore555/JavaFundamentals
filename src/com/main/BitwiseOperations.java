package com.main;

public class BitwiseOperations {

	public static void main(String[] args) {
		System.out.println(5^4^17^4^5);
		
		System.out.println(1&-1);
		System.out.println(4&-4);
		System.out.println(7&-7);
		System.out.println(Integer.toBinaryString(1<<3));
		System.out.println(Integer.toBinaryString(~(1<<3)));
		System.out.println(Integer.toBinaryString(1) + "-" + Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(7) + "-" + Integer.toBinaryString(-7));
		System.out.println(Integer.toBinaryString(4) + "-" + Integer.toBinaryString(-4));
		
		int mask = 7;
		System.out.println("mask:" + Integer.toBinaryString(mask));
		System.out.println(Integer.toBinaryString(mask & (mask-1)));
		System.out.println(Integer.toBinaryString(mask | (1 << 1)));
		System.out.println(Integer.toBinaryString(mask & (1 << 1)));
		System.out.println(Integer.toBinaryString(mask ^ (1 << 1)));
		
		int bits = 0;
		System.out.println("bits:" + Integer.toBinaryString(bits));
		bits |= (1 << 1);
		System.out.println(Integer.toBinaryString(bits));
		System.out.println(Integer.toBinaryString(bits | (1 << 2)));
		System.out.println(Integer.toBinaryString(bits ^ (1 << 2)));
		System.out.println(Integer.toBinaryString(bits & ~(1 << 2)));
		System.out.println(Integer.toBinaryString(bits & (1 << 2)));
		
		System.out.println(Integer.toBinaryString((1 << 12)-1));
		System.out.println((1 << 12)-1);
		
		int x = 7;
		System.out.println("x:"+Integer.toBinaryString(x));
		x = x & x-1;
		System.out.println("x:"+Integer.toBinaryString(x));
	}

}
