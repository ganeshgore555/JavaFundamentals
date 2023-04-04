package com.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class ComparatorApi {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("resources", "personDob.txt");
		Stream<String> lineStream = Files.lines(path);
		Comparator<Person> personComparator = Comparator.comparing(Person::getName);
		ArrayList<Person> personList = new ArrayList<Person>();
		lineStream.forEach(l -> {
			String[] personVals = l.split(" ");
			Person person = new Person(personVals[0],Integer.parseInt(personVals[1]), LocalDate.of(Integer.parseInt(personVals[2]), Integer.parseInt(personVals[3]), Integer.parseInt(personVals[4])));
			personList.add(person);
		});
		personList.stream().sorted(personComparator).forEach(System.out::println);
		
	}

}
