package com.main;

public class TryCatchFinally {

	public static void main(String[] args) {
		System.out.println("Return " + testReturnFromTry());
		System.out.println("Return " + testReturnFromTryWithException());
	}

	private static int testReturnFromTry() {
		try {
			System.out.println("Try");
			return 0;
		}catch(Exception e){
			System.out.println("Catch");
			return 1;
		}finally {
			System.out.println("Finally");
			//return 2;			
		}
	}

	private static int testReturnFromTryWithException() {
		try {
			System.out.println("Try");
			int i = 9/0;
			return 0;
		}catch(Exception e){
			System.out.println("Catch");
			return 1;
		}finally {
			System.out.println("Finally");
			//return 2;			
		}
	}
}
