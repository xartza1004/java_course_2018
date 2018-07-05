package com.example.demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {

	public static void main(String[] args) {
		MainStream p = new MainStream();
		p.start();
	}
	
	public void start() {
		// Array
		String[] datas = new String[] {"One", "Two", "Three"};
		Stream<String> stream = Arrays.stream(datas);
		stream.forEach(System.out::println);
		System.out.println();
		
		// Collection
		List<String> lists = new ArrayList<>();
		lists.add("One");
		lists.add("Two");
		lists.add("Three");
		lists.stream().forEach(System.out::println);
		System.out.println();
		
		// Filter data that start with "T"
		List<String> after = new ArrayList<>(); //Old Fashion
		for (String string : lists) {
			if (string.startsWith("T")) {
				after.add(string);
			}
		}
		
		List<String> result =
				lists.stream()
				.filter(string -> string.startsWith("T")) // Filter with Stream
				.map(string -> string.toLowerCase()) // Convert to lower case
				.collect(Collectors.toList()); // Save output to List
		result.forEach(System.out::println);
	}

}
