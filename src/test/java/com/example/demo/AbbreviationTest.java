package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbbreviationTest {

	@Test
	public void old_fashion_USA() {
		Abbreviation oldFashion = new Abbreviation();
		String result = oldFashion.oldFashionProcess("United States of America");
		assertEquals("USA", result);
	}
	
	@Test
	public void old_fashion_usa_toUSA() {
		Abbreviation oldFashion = new Abbreviation();
		String result = oldFashion.oldFashionProcess("united states of america");
		assertEquals("USA", result);
	}
	
	@Test
	public void old_fashion_LASER() {
		Abbreviation oldFashion = new Abbreviation();
		String result = oldFashion.oldFashionProcess("Light Amplification by Stimulation of Emitted Radiation");
		assertEquals("LASER", result);
	}
	
	@Test
	public void old_fashion_JTW() {
		Abbreviation oldFashion = new Abbreviation();
		String result = oldFashion.oldFashionProcess("Jordan Of the World");
		assertEquals("JTW", result);
	}
	
	@Test
	public void stream_USA() {
		Abbreviation stream = new Abbreviation();
		String result = stream.streamProcess("United States of America");
		assertEquals("USA", result);
	}
	
	@Test
	public void stream_usa_toUSA() {
		Abbreviation stream = new Abbreviation();
		String result = stream.streamProcess("united states of america");
		assertEquals("USA", result);
	}
	
	@Test
	public void stream_LASER() {
		Abbreviation stream = new Abbreviation();
		String result = stream.streamProcess("Light Amplification by Stimulation of Emitted Radiation");
		assertEquals("LASER", result);
	}
	
	@Test
	public void stream_JTW() {
		Abbreviation stream = new Abbreviation();
		String result = stream.streamProcess("Jordan Of the World");
		assertEquals("JTW", result);
	}

}
