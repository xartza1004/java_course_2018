package com.example.demo.harrypotter;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private final List<BookItem> bookItems = new ArrayList<>();

	private double totalPrice;
	private double discount;
	private double netPrice;

	public int getBookAmount() {
		return bookItems.size();
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void addItem(BookItem bookItem) {
		bookItems.add(bookItem);
	}

	public void process() {
		if (!bookItems.isEmpty()) {
			calculateTotalPrice();
			calculateDiscount();

			// Calculate net price
			netPrice = getTotalPrice() - getDiscount();
		}
	}

	private void calculateDiscount() {
		discount = 0;
		if (getBookAmount() == 2) {
			discount = getTotalPrice() * 0.05;
		}
		if (getBookAmount() == 3) {
			discount = getTotalPrice() * 0.1;
		}
	}

	private void calculateTotalPrice() {
		for (BookItem bookItem : bookItems) {
			// Don't use getBook().getPrice() by Law of Demeter
			totalPrice += bookItem.getTotalPrice();
		}
	}

}
