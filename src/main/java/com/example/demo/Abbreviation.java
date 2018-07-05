package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Abbreviation {
	
	private final List<String> except = Arrays.asList(new String[] {"BY", "OF"});
	
	public String oldFashionProcess(String input) {
		String[] words = input.toUpperCase().split(" ");
		String result = "";
		
		for (String word : words) {
			if (!except.contains(word)) {
				result += word.charAt(0);
			}
		}
		
		return result;
	}
	
	public String streamProcess(String input) {
		return Stream.of(input.toUpperCase().split(" "))
				.filter(word -> !except.contains(word))
				.map(word -> String.valueOf(word.charAt(0)))
				.collect(Collectors.joining());
	}
	
}
