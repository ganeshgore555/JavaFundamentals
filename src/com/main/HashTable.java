package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HashTable {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(-1);
		list1.add(0);
		list1.add(1);
		Collections.sort(list1);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(0);
		list2.add(1);
		list2.add(-1);
		Collections.sort(list2);
		
		set.add(list1);
		set.add(list2);
		System.out.println(set);
	}

}
