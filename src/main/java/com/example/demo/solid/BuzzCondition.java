package com.example.demo.solid;

public class BuzzCondition implements Condition {
	
	@Override
	public boolean check(int input) {
		return input % 5 == 0;
	}
	
	@Override
	public String say(int input) {
		return "Buzz";
	}
	
}
