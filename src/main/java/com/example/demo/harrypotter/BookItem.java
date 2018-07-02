package com.example.demo.harrypotter;

public class BookItem {

	private Book book;
	private int quantity;

	public BookItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return book.getPrice();
	}

	public double getTotalPrice() {
		return getPrice() * quantity;
	}

	public void addBook() {
		quantity++;
	}

	public void addMoreBook(BookItem bookItem) {
		quantity += bookItem.getQuantity();
	}

	public void pickBook() {
		quantity--;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + quantity;
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
		BookItem other = (BookItem) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		// if (quantity != other.quantity)
		// return false;
		return true;
	}

}
