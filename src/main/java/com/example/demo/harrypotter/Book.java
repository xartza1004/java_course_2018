package com.example.demo.harrypotter;

public class Book {

	// final = immutable
	// Static
	// Non-static

	// Variable
	private String name;
	private double price;
	private int stock;

	// Constructor
	public Book(String name, double price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	// Getters Setters

	public double getPrice() {
		return price;
	}

	// Public method

	public static Book createHarryPotterOne() {
		return new Book("H1", 8, 2);
	}

	public static Book createHarryPotterTwo() {
		return new Book("H2", 8, 2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + stock;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		// if (stock != other.stock)
		// return false;
		return true;
	}

	// Private method

}
