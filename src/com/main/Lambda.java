package com.main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Lambda {

	public static void main(String[] args) {
		Predicate<String> userPredicate = s -> {
			if (s.equals("Good"))
				return true;
			return false;
		};
		System.out.println(userPredicate.test("Good"));
		System.out.println(userPredicate.test("Bad"));
		System.out.println(userPredicate.test("Ugly"));

		Predicate<String> strLen5 = (s -> s.length() >= 5);

		System.out.println(strLen5.test("12345"));
		System.out.println(strLen5.test("1234"));

		List<String> list = Arrays.asList("1", "1234567", "12345", "12", "12345678", "1234", "123", "123456");
		ArrayList<String> newList = new ArrayList<String>();
		Consumer<String> print = System.out::println;
		Predicate<String> filterLen = s -> s.length() > 5;
		System.out.println("All Nos");
		list.forEach(print);
		System.out.println("Filtered Nos");
		list.stream().filter(filterLen).peek(newList::add).forEach(print);
		System.out.println("Size:" + newList.size());
		
		System.out.println("Map");
		list.stream().map(l -> l.length()).forEach(System.out::println);

		Optional<Integer> optLengthSum = list.stream().map(l -> l.length()).reduce((a,b) -> a+b);
		if(optLengthSum.isPresent())
			System.out.println("Len Sum : " + optLengthSum.get());
		
		String concat = list.stream().reduce("",(a,b) -> a+b);
		System.out.println(concat);
		
		Optional<Integer> optMinInt = list.stream().map(l -> l.length()).filter(l -> l > 5).min(Comparator.naturalOrder());
		System.out.println("Min Len : " + optMinInt.get());
		Optional<Integer> optMaxInt = list.stream().map(l -> l.length()).filter(l -> l > 5).max(Comparator.naturalOrder());
		System.out.println("Max Len : " + optMaxInt.get());
	}
}
