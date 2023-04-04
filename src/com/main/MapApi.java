package com.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapApi {

	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("resources", "person1.txt");
		Stream<String> file1Stream = Files.lines(path1);
		Path path2 = Paths.get("resources", "person2.txt");
		Stream<String> file2Stream = Files.lines(path2);
		
		Map<Integer, List<Person>> map1 = file1Stream.map(l -> {
			String[] personVals = l.split(" ");
			Person person = new Person(personVals[0],Integer.parseInt(personVals[1]), LocalDate.of(Integer.parseInt(personVals[2]), Integer.parseInt(personVals[3]), Integer.parseInt(personVals[4])));
			return person;
		}).collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Map 1");
		map1.forEach((age, list) -> System.out.println("age" + age +" -> " + list ));
		Map<Integer, List<Person>> map2 = file2Stream.map(l -> {
			String[] personVals = l.split(" ");
			Person person = new Person(personVals[0],Integer.parseInt(personVals[1]), LocalDate.of(Integer.parseInt(personVals[2]), Integer.parseInt(personVals[3]), Integer.parseInt(personVals[4])));
			return person;
		}).collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Map 2");
		map2.forEach((age, list) -> System.out.println("age" + age +" -> " + list ));
		map2.entrySet().stream().forEach(entry -> {
			map1.merge(entry.getKey(), entry.getValue(), (l1,l2) -> {
				l1.addAll(l2);
				return l1;
			});
		});
		System.out.println("Map Merged");
		map1.forEach((age, list) -> System.out.println("age" + age +" -> " + list ));
	}

}
