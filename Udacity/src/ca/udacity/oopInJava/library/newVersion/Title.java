package ca.udacity.oopInJava.library.newVersion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class Title {
	private final String title;
	private final String isbn;
	private double value;
	private double finePerDay=0.10;
	private int numCopies;
	
	List<Item> items = new ArrayList<Item>();
	private List<Patron> patrons = new LinkedList<Patron>(); // FIFO for patrons who did requests
	
	Title(String title, String isbn, double value, int numCopies) /*throws Exception*/ {
		this.title = title;
		this.isbn = isbn;
		this.value = value;
		if (this.finePerDay > value) this.finePerDay = value;
		this.numCopies = numCopies;
	}
	
	public final String getIsbn() {
		return this.isbn;
	}
		
	public String getTitle() {
		return this.title;
	}
	
	boolean removeItem(int itemID) {
		for (Item item:items) 
			if(item.getIdentifier() == itemID) {
				items.remove(item);
				this.numCopies--;
				return true;
			}
		return false;
	}
	
	public int getNumCopies() {
		return this.numCopies;
	}
	
	public double getValue() {
		return value;
	}

	public double getFinePerDay() {
		return finePerDay;
	}
	
	public void setFinePerDay(double finePerDay) {
		this.finePerDay = (finePerDay > this.value)?this.value:finePerDay;
		
	}
	
	void listAllItems() {
		for (Item item:items) System.out.println(item);
	}
	
	boolean requestTitle(Patron patron) {
		if (isTitleAlreadyRequested(patron)) return false;
		patrons.add(patron);
		return true;
	}

	Patron requestedTitlePrioryPatron() {
		if (patrons.isEmpty()) return null;
		return patrons.get(0);
	}
	
	boolean removeRequest(Patron patron) {
		return patrons.remove(patron);
	}
	
	private boolean isTitleAlreadyRequested(Patron patron) {
		return patrons.contains(patron);
	}
	
	public boolean isRequestExists() {
		return !patrons.isEmpty();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (title: ");
		result.append(this.title);
		result.append(", value: ");
		result.append(this.value);
		result.append(", numCopies: ");
		result.append(this.numCopies);
		result.append(')');
		return result.toString();
	}
	
	public abstract boolean isLoanable();
	
		
// TODO Remove unused code found by UCDetector
// 	public boolean isRequestExists(Patron patron) {
// 		return patrons.contains(patron);
// 	}

	//	@Override
	//	public boolean equals(Object o) {
	//		boolean result = false;
	//		if (o != null && o instanceof Title) {
	//			Title other = (Title)o;
	//			result = (this.isbn == other.isbn);
	//		}
	//			
	//		return result;
	//	}

}
