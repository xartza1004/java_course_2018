package com.example.demo.solid;

import java.util.Random;

interface MyRandom {
	
	public int nextInt();
	
}

public class RandomNumber {
	
	public int generateNumber(MyRandom random) {
		return random.nextInt();
	}
	
}
