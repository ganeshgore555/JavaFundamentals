package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.Stream;

public class DateApi {

	public static void main(String[] args) throws IOException {
		Instant start = Instant.now();
		BufferedReader br = new BufferedReader(new FileReader(new File(".//resources//personDob.txt")));
		ArrayList<Person> personList = new ArrayList<Person>();
		LocalDate now = LocalDate.now();
		Stream<String> stream = br.lines();
		stream.map(l -> {
			String[] personVals = l.split(" ");
			Person person = new Person(personVals[0],Integer.parseInt(personVals[1]), LocalDate.of(Integer.parseInt(personVals[2]), Integer.parseInt(personVals[3]), Integer.parseInt(personVals[4])));
			personList.add(person);
			return person;
		}).forEach(p -> {
			Period period = Period.between(p.getDateOfBirth(), now);
			System.out.println(p.getName() + " was born before " + period.getYears() + " years and " + period.getMonths() + " months" + " [" + p.getDateOfBirth().until(now, ChronoUnit.MONTHS ) + "]");
		});
		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println("Time in ms : " + duration.toMillis());
	}

}
