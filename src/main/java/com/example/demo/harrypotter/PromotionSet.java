package com.example.demo.harrypotter;

import java.util.ArrayList;
import java.util.List;

public class PromotionSet {

	private final List<Book> books = new ArrayList<>();

	private double setPrice;
	private double discount;

	public double getDiscount() {
		return discount;
	}
	
	public boolean contains(Book book) {
		return books.contains(book);
	}

	public void addBook(BookItem bookItem) {
		if (!books.contains(bookItem.getBook()) && books.size() < 5) {
			books.add(bookItem.getBook());
			bookItem.pickBook();
			setPrice += bookItem.getPrice();
			calculateDiscount();
		}
	}

	public List<BookItem> returnBook() {
		List<BookItem> returnBookItem = new ArrayList<>();

		while (!books.isEmpty()) {
			returnBookItem.add(new BookItem(books.remove(0), 1));
		}

		setPrice = 0;
		discount = 0;
		return returnBookItem;
	}

	private void calculateDiscount() {
		double multiply = 0;

		if (books.size() == 2) {
			multiply = 0.05;
		} else if (books.size() == 3) {
			multiply = 0.1;
		} else if (books.size() == 4) {
			multiply = 0.2;
		} else if (books.size() == 5) {
			multiply = 0.25;
		}

		discount = setPrice * multiply;
	}

}
