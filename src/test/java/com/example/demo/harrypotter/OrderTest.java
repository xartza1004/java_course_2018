package com.example.demo.harrypotter;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {
	
	@Test
	public void createOrderWithThatCase() {
		Book book1 = new Book("H1", 8, 2);
		Book book2 = new Book("H2", 8, 2);
		Book book3 = new Book("H3", 8, 2);
		Book book4 = new Book("H4", 8, 2);
		Book book5 = new Book("H5", 8, 2);
		BookItem bookItem1 = new BookItem(book1, 2);
		BookItem bookItem2 = new BookItem(book2, 2);
		BookItem bookItem3 = new BookItem(book3, 2);
		BookItem bookItem4 = new BookItem(book4, 1);
		BookItem bookItem5 = new BookItem(book5, 1);
		Order order = new Order();
		order.addItem(bookItem1);
		order.addItem(bookItem2);
		order.addItem(bookItem3);
		order.addItem(bookItem4);
		order.addItem(bookItem5);
		order.process();

		assertEquals(5, order.getBookAmount());
		assertEquals(64, order.getTotalPrice(), 0.01);
		assertEquals(12.8, order.getDiscount(), 0.01);
		assertEquals(51.2, order.getNetPrice(), 0.01);
	}
	
	@Test
	public void createOrderWithFiveAndOneBook() {
		Book book1 = new Book("H1", 8, 2);
		Book book2 = new Book("H2", 8, 2);
		Book book3 = new Book("H3", 8, 2);
		Book book4 = new Book("H4", 8, 2);
		Book book5 = new Book("H5", 8, 2);
		BookItem bookItem1 = new BookItem(book1, 1);
		BookItem bookItem2 = new BookItem(book2, 1);
		BookItem bookItem3 = new BookItem(book3, 2);
		BookItem bookItem4 = new BookItem(book4, 1);
		BookItem bookItem5 = new BookItem(book5, 1);
		Order order = new Order();
		order.addItem(bookItem1);
		order.addItem(bookItem2);
		order.addItem(bookItem3);
		order.addItem(bookItem4);
		order.addItem(bookItem5);
		order.process();

		assertEquals(5, order.getBookAmount());
		assertEquals(48, order.getTotalPrice(), 0.01);
		assertEquals(10, order.getDiscount(), 0.01);
		assertEquals(38, order.getNetPrice(), 0.01);
	}
	
	@Test
	public void createOrderWithFiveBook() {
		Book book1 = new Book("H1", 8, 2);
		Book book2 = new Book("H2", 8, 2);
		Book book3 = new Book("H3", 8, 2);
		Book book4 = new Book("H4", 8, 2);
		Book book5 = new Book("H5", 8, 2);
		BookItem bookItem1 = new BookItem(book1, 1);
		BookItem bookItem2 = new BookItem(book2, 1);
		BookItem bookItem3 = new BookItem(book3, 1);
		BookItem bookItem4 = new BookItem(book4, 1);
		BookItem bookItem5 = new BookItem(book5, 1);
		Order order = new Order();
		order.addItem(bookItem1);
		order.addItem(bookItem2);
		order.addItem(bookItem3);
		order.addItem(bookItem4);
		order.addItem(bookItem5);
		order.process();

		assertEquals(5, order.getBookAmount());
		assertEquals(40, order.getTotalPrice(), 0.01);
		assertEquals(10, order.getDiscount(), 0.01);
		assertEquals(30, order.getNetPrice(), 0.01);
	}
	
	@Test
	public void createOrderWithFourBook() {
		Book book1 = new Book("H1", 8, 2);
		Book book2 = new Book("H2", 8, 2);
		Book book3 = new Book("H3", 8, 2);
		Book book4 = new Book("H4", 8, 2);
		BookItem bookItem1 = new BookItem(book1, 1);
		BookItem bookItem2 = new BookItem(book2, 1);
		BookItem bookItem3 = new BookItem(book3, 1);
		BookItem bookItem4 = new BookItem(book4, 1);
		Order order = new Order();
		order.addItem(bookItem1);
		order.addItem(bookItem2);
		order.addItem(bookItem3);
		order.addItem(bookItem4);
		order.process();

		assertEquals(4, order.getBookAmount());
		assertEquals(32, order.getTotalPrice(), 0.01);
		assertEquals(6.4, order.getDiscount(), 0.01);
		assertEquals(25.6, order.getNetPrice(), 0.01);
	}
	
	@Test
	public void createOrderWithThreeBook() {
		Book book1 = new Book("H1", 8, 2);
		Book book2 = new Book("H2", 8, 2);
		Book book3 = new Book("H3", 8, 2);
		BookItem bookItem1 = new BookItem(book1, 1);
		BookItem bookItem2 = new BookItem(book2, 1);
		BookItem bookItem3 = new BookItem(book3, 1);
		Order order = new Order();
		order.addItem(bookItem1);
		order.addItem(bookItem2);
		order.addItem(bookItem3);
		order.process();

		assertEquals(3, order.getBookAmount());
		assertEquals(24, order.getTotalPrice(), 0.01);
		assertEquals(2.4, order.getDiscount(), 0.01);
		assertEquals(21.6, order.getNetPrice(), 0.01);
	}
	
	@Test
	public void createOrderWithTwoBook() {
		Book book1 = new Book("H1", 8, 2);
		Book book2 = new Book("H2", 8, 2);
		BookItem bookItem1 = new BookItem(book1, 1);
		BookItem bookItem2 = new BookItem(book2, 1);
		Order order = new Order();
		order.addItem(bookItem1);
		order.addItem(bookItem2);
		order.process();

		assertEquals(2, order.getBookAmount());
		assertEquals(16, order.getTotalPrice(), 0.01);
		assertEquals(0.8, order.getDiscount(), 0.01);
		assertEquals(15.2, order.getNetPrice(), 0.01);
	}

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
