package com.example.demo.harrypotter;

public class Order {
	
	private int bookAmount;
	private double totalPrice;
	private double discount;
	private double netPrice;
	private BookItem bookItem;

	public int getBookAmount() {
		return bookAmount;
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
		this.bookItem = bookItem;
	}

	public void process() {
		if(this.bookItem != null) {
			this.bookAmount = 1;
			
			//Calculate price
			this.totalPrice = bookItem.getBook().getPrice();
			
			//Calculate discount
			this.discount = 0;
			
			//Calculate net price
			this.netPrice = getTotalPrice() - getDiscount();
		}
	}
	
}
