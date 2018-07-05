package com.example.demo.solid;

public class FizzBuzzCondition implements Condition {
	
	@Override
	public boolean check(int input) {
		return input % 15 == 0;
	}
	
	@Override
	public String say(int input) {
		return "FizzBuzz";
	}
	
}
