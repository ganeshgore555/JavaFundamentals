package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CollectorsApi {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(".//resources//person.txt")));
		ArrayList<Person> personList = new ArrayList<Person>();
		Stream<String> stream = br.lines();
		stream.map(l -> {
			String[] personVals = l.split(" ");
			Person person = new Person(personVals[0],Integer.parseInt(personVals[1]));
			personList.add(person);
			return person;
		}).filter(p -> p.age < 35).forEach(System.out::println);
		
		Optional<Person> optPersonMinAge = personList.parallelStream().reduce((Person a,Person b) -> a.age < b.age ? a : b);
		System.out.println(optPersonMinAge);
		
		Optional<Person> optPersonMinAgeComp = personList.parallelStream().max(Comparator.comparing(Person::getAge));
		System.out.println(optPersonMinAgeComp);
		
		Map<Integer, List<Person>> mapByAge = personList.parallelStream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println(mapByAge);

		Map<Integer, Long> mapByAgeAndCount = personList.parallelStream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
		System.out.println(mapByAgeAndCount);
		
		Map<Integer, List<String>> mapByAgeAndGetNameList = personList.parallelStream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println(mapByAgeAndGetNameList);

		Map<Integer, TreeSet<String>> mapByAgeAndGetNameTreeSet = personList.parallelStream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))));
		System.out.println(mapByAgeAndGetNameTreeSet);
		
		Double avgAge = personList.parallelStream().collect(Collectors.averagingInt(Person::getAge));
		System.out.println(avgAge);
		
		
		Long count = personList.parallelStream().collect(Collectors.counting());
		System.out.println(count);
		
	}

}
