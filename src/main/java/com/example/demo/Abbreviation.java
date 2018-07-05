package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Abbreviation {
	
	private final List<String> except = Arrays.asList(new String[] {"BY", "OF"});
	
	public String oldFashionProcess(String input) {
		String[] words = input.toUpperCase().split(" ");
		List<String> result = new ArrayList<>();
		
		for (String word : words) {
			if (!except.contains(word)) {
				result.add(word.substring(0, 1));
			}
		}
		
		return String.join("", result);
	}
	
	public String streamProcess(String input) {
		String[] words = input.toUpperCase().split(" ");
		Stream<String> stream = Arrays.stream(words);
		
		List<String> result = stream
				.filter(string -> !except.contains(string))
				.map(string -> string.substring(0, 1))
				.collect(Collectors.toList());
		
		return String.join("", result);
	}
	
}
