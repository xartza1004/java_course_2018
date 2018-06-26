package com.example.demo.harrypotter;

public class BookBuilder {
	
	private String name;
	private double price;
	
	public BookBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public BookBuilder setPrice(double price) {
		this.price = price;
		return this;
	}
	
	public Book build() {
		return new Book(this.name, this.price, 1);
	}
}
