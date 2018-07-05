package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorizeTest {

	@Test
	public void case_2() {
		Factorize factorize = new Factorize();
		assertEquals("2", factorize.of(2));
	}
	
	@Test
	public void case_3() {
		Factorize factorize = new Factorize();
		assertEquals("3", factorize.of(3));
	}

	@Test
	public void case_4() {
		Factorize factorize = new Factorize();
		assertEquals("2, 2", factorize.of(4));
	}
	
	@Test
	public void case_5() {
		Factorize factorize = new Factorize();
		assertEquals("5", factorize.of(5));
	}
	
	@Test
	public void case_6() {
		Factorize factorize = new Factorize();
		assertEquals("2, 3", factorize.of(6));
	}
	
	@Test
	public void case_7() {
		Factorize factorize = new Factorize();
		assertEquals("7", factorize.of(7));
	}
	
	@Test
	public void case_8() {
		Factorize factorize = new Factorize();
		assertEquals("2, 2, 2", factorize.of(8));
	}
	
	@Test
	public void case_9() {
		Factorize factorize = new Factorize();
		assertEquals("3, 3", factorize.of(9));
	}
	
	@Test
	public void case_10() {
		Factorize factorize = new Factorize();
		assertEquals("2, 5", factorize.of(10));
	}
	
	@Test
	public void case_11() {
		Factorize factorize = new Factorize();
		assertEquals("11", factorize.of(11));
	}

}
