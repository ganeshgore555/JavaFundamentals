package com.main;

import java.io.FileNotFoundException;

public class CompileTimeExceptions {

	public static void main(String[] args) throws FileNotFoundException {
		//throw new RuntimeException();
		throw new FileNotFoundException();
		//throw new ArrayIndexOutOfBoundsException();		
	}

}
