package com.main;

import java.util.StringJoiner;

public class StringApi {

	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner(", ","{","}");
		sj.add("1").add("2").add("3");
		System.out.println(sj.toString());
	}

}
