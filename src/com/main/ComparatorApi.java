package com.main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ComparatorApi {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Path path = Paths.get("resources", "personDob.txt");
		Stream<String> lineStream = Files.lines(path);
		Comparator<Person> personComparator = Comparator.comparing(Person::getName);
		ArrayList<Person> personList = new ArrayList<Person>();
		lineStream.forEach(l -> {
			String[] personVals = l.split(" ");
			Person person = new Person(personVals[0],Integer.parseInt(personVals[1]), LocalDate.of(Integer.parseInt(personVals[2]), Integer.parseInt(personVals[3]), Integer.parseInt(personVals[4])));
			personList.add(person);
		});
		//personList.stream().sorted(personComparator).forEach(System.out::println);
		String[] attributes = {"name","age"};
		new ComparatorApi().sortList(personList, attributes);
		System.out.println("Generic Comparator");
		personList.stream().forEach(System.out::println);
	}

	public <T> void sortList(List<T> objList, String[] attributes) throws ClassNotFoundException {
		Comparator<T> comparator = null;
		Comparator<T> temp = null;
		if(objList != null) {
			Class classObj = objList.get(0).getClass();
			Method[] methods = classObj.getMethods();
			for(String attribute : attributes) {
				for(Method method : methods) {
					if(method.getName().contains("get") && method.getName().toLowerCase().contains(attribute.toLowerCase()))
						temp = new Comparator<T>() {
							@Override
							public int compare(T o1, T o2) {
								try {
									Comparable v1 = (Comparable) method.invoke(o1);
									Comparable v2 = (Comparable) method.invoke(o2);
									return v1.compareTo(v2);
								} catch (IllegalAccessException | InvocationTargetException e) {
									e.printStackTrace();
								}
								return 0;
							}
						};
						if(temp != null)
							if(comparator == null)
								comparator = temp;
							else
								comparator = comparator.thenComparing(temp);
				}
			}
			if(comparator != null)
				objList.sort(comparator);
		}
	}
	
}
