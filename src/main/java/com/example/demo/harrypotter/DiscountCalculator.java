package com.example.demo.harrypotter;

import java.util.ArrayList;
import java.util.List;

public class DiscountCalculator {

	private final List<BookItem> bookItems;
	private final List<PromotionSet> bookSets = new ArrayList<>();

	public DiscountCalculator(List<BookItem> bookItems) {
		this.bookItems = bookItems;
	}

	public double calculateDiscount() {
		double discount = 0.0;
		double bestDiscount = 0.0;
		
		for (int i = bookItems.size(); i > 0; i--) {
			while (!bookItems.isEmpty()) {
				bookSets.add(setBookSet(i));
			}
			discount = getNowDiscount();
			if (discount > bestDiscount) {
				bestDiscount = discount;
			}
			resetBookSets();
		}
		
		return bestDiscount;
	}
	
	private double getNowDiscount() {
		double discount = 0.0;
		
		for (PromotionSet bookSet : bookSets) {
			discount += bookSet.getDiscount();
		}
		
		return discount;
	}
	
	private void resetBookSets() {
		List<BookItem> bookItems;
		while (!bookSets.isEmpty()) {
			bookItems = bookSets.remove(0).returnBook();
			for (BookItem bookItem : bookItems) {
				addItem(bookItem);
			}
		}
	}
	
	private void addItem(BookItem bookItem) {
		if (bookItems.contains(bookItem)) {
			bookItems.get(bookItems.indexOf(bookItem)).addMoreBook(bookItem);
		} else {
			bookItems.add(bookItem);
		}
	}
	
	private boolean itemOutAtZeroQuantity(BookItem bookItem) {
		if (bookItem.getQuantity() < 1) {
			bookItems.remove(bookItem);
			return true;
		}
		return false;
	}
	
	private BookItem findMax(PromotionSet currentSet) {
		BookItem maxQuantity = null;
		for (BookItem bookItem : bookItems) {
			if (currentSet.contains(bookItem.getBook())) {
				continue;
			} else if (maxQuantity == null || bookItem.getQuantity() > maxQuantity.getQuantity()) {
				maxQuantity = bookItem;
			}
		}
		return maxQuantity;
	}
	
	private PromotionSet setBookSet(int setAmount) {
		PromotionSet bookSet;
		BookItem bookItem;
		
		if (bookItems.size() < setAmount) {
			bookSet = setBookSet(setAmount-1);
		} else {
			bookSet = new PromotionSet();
			for (int i = 0; i < setAmount; i++) {
				bookItem = findMax(bookSet);
				bookSet.addBook(bookItem);
				itemOutAtZeroQuantity(bookItem);
			}
		}
		
		return bookSet;
	}

	/*private PromotionSet fiveBookSet() {
		PromotionSet fiveSet;
		int itemsSize = bookItems.size();
		
		if (itemsSize < 5) {
			fiveSet = fourBookSet();
		} else {
			fiveSet = new PromotionSet();
			for (int i = 0; i < itemsSize; ) {
				fiveSet.addBook(bookItems.get(i));
				if (itemOutAtZeroQuantity(bookItems.get(i))) {
					itemsSize--;
				} else {
					i++;
				}
			}
		}

		return fiveSet;
	}
	
	private PromotionSet fourBookSet() {
		PromotionSet fourSet;
		BookItem bookItem;
		
		if (bookItems.size() < 4) {
			fourSet = threeBookSet();
		} else {
			fourSet = new PromotionSet();
			for (int i = 0; i < 4; i++) {
				bookItem = findMax(fourSet);
				fourSet.addBook(bookItem);
				itemOutAtZeroQuantity(bookItem);
			}
		}
		
		return fourSet;
	}
	
	private PromotionSet threeBookSet() {
		PromotionSet threeSet;
		BookItem bookItem;
		
		if (bookItems.size() < 3) {
			threeSet = twoBookSet();
		} else {
			threeSet = new PromotionSet();
			for (int i = 0; i < 3; i++) {
				bookItem = findMax(threeSet);
				threeSet.addBook(bookItem);
				itemOutAtZeroQuantity(bookItem);
			}
		}
		
		return threeSet;
	}
	
	private PromotionSet twoBookSet() {
		PromotionSet twoSet;
		BookItem bookItem;
		
		if (bookItems.size() < 2) {
			twoSet = aBookSet();
		} else {
			twoSet = new PromotionSet();
			for (int i = 0; i < 2; i++) {
				bookItem = findMax(twoSet);
				twoSet.addBook(bookItem);
				itemOutAtZeroQuantity(bookItem);
			}
		}
		
		return twoSet;
	}
	
	private PromotionSet aBookSet() {
		PromotionSet aSet = new PromotionSet();
		aSet.addBook(bookItems.get(0));
		itemOutAtZeroQuantity(bookItems.get(0));
		
		return aSet;
	}*/

}
