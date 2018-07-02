package com.example.demo.harrypotter;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private final List<BookItem> bookItems = new ArrayList<>();
	private final DiscountCalculator discountCalculator = new DiscountCalculator(bookItems);

	private double totalPrice;
	private double discount;
	private double netPrice;

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public int getBookAmount() {
		return bookItems.size();
	}

	public void addItem(BookItem bookItem) {
		if (bookItems.contains(bookItem)) {
			bookItems.get(bookItems.indexOf(bookItem)).addMoreBook(bookItem);
		} else {
			bookItems.add(bookItem);
		}
	}

	public void process() {
		if (!bookItems.isEmpty()) {
			calculateTotalPrice();
			discount = discountCalculator.calculateDiscount();
			netPrice = getTotalPrice() - getDiscount();
		}
	}

	private void calculateTotalPrice() {
		totalPrice = 0;
		for (BookItem bookItem : bookItems) {
			// Don't use getBook().getPrice() by Law of Demeter
			totalPrice += bookItem.getTotalPrice();
		}
	}

}
