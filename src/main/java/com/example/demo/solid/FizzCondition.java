package com.example.demo.solid;

public class FizzCondition implements Condition {
	
	@Override
	public boolean check(int input) {
		return input % 3 == 0;
	}
	
	@Override
	public String say(int input) {
		return "Fizz";
	}
	
}
