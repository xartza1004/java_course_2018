package com.example.demo.solid;

public class KBTGCondition implements Condition {

	@Override
	public boolean check(int input) {
		return input % 7 == 0;
	}

	@Override
	public String say(int input) {
		return "KBTG";
	}

}
