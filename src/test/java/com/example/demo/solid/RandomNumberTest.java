package com.example.demo.solid;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class RandomNumberTest {

	@Test
	public void random_5() {
		RandomNumber demo = new RandomNumber();
		assertEquals(5, demo.generateNumber(new Random5()));
	}

}

class Random5 implements MyRandom {
	@Override
	public int nextInt() {
		return 5;
	}
}
