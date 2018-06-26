package com.example.demo.harrypotter;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {
	
	@Test
	public void createOrderWithOneBook() {
		Book book1 = new Book("H1", 8, 2);
		BookItem bookItem = new BookItem(book1, 1);
		Order order = new Order();
		order.addItem(bookItem);
		order.process();
		
		assertEquals(1, order.getBookAmount());
		assertEquals(8, order.getTotalPrice(), 0.01);
		assertEquals(0, order.getDiscount(), 0.01);
		assertEquals(8, order.getNetPrice(), 0.01);
	}

	@Test
	public void createEmptyOrder() {
		Order order = new Order();
		order.process();
		assertEquals(0, order.getBookAmount());
		assertEquals(0, order.getTotalPrice(), 0.01);
		assertEquals(0, order.getDiscount(), 0.01);
		assertEquals(0, order.getNetPrice(), 0.01);
	}

}
