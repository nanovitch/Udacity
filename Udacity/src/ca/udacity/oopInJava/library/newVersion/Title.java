package ca.udacity.oopInJava.library.newVersion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Title {
	private final String title;
	private final String isbn;
	private double value;
	private double finePerDay=0.10;
	private final char type;
	private int numCopies;
	
	//private int numOfLoans = 0;
	private List<Item> items = new ArrayList<Item>();
	private List<Patron> patrons = new LinkedList<Patron>(); // FIFO
	
	public Title(String title, String isbn, double value, char type, int numCopies) /*throws Exception*/ {
		assert(type=='A' || type=='B' || type=='S' || type=='M' || type=='R'):"UNHANDLED ITEM TYPE!!!";
		this.title = title;
		this.isbn = isbn;
		this.value = value;
		if (this.finePerDay > value) this.finePerDay = value;
		switch (type) {
		case 'A': // AudioVideo
			for (int i=0; i < numCopies; i++) items.add(new AudioVideo(this));
			break;
		case 'B': // Book
			for (int i=0; i < numCopies; i++) items.add(new Book(this, false));
			break;
		case 'S': // BestSeller
			for (int i=0; i < numCopies; i++) items.add(new Book(this, true));
			break;
		case 'M': // Magazine
			for (int i=0; i < numCopies; i++) items.add(new Magazine(this));
			break;
		case 'R': // RefBook
			for (int i=0; i < numCopies; i++) items.add(new RefBook(this));
			break;
		default:
			//throw new Exception();
				
		}
		this.type = type;
		this.numCopies = numCopies;
	}
	
	public final String getIsbn() {
		return this.isbn;
	}
		
	public String getTitle() {
		return this.title;
	}
	
	public char getType() {
		return this.type;
	}
	
	public boolean isLoanable() {
		return (this.type == 'A' || this.type == 'B' || this.type == 'S');
	}
	
	public boolean addItems(int numCopies) {
		switch (this.type) {
			case 'A': 
				for (int i=0; i < numCopies; i++) items.add(new AudioVideo(this));
				this.numCopies += numCopies;
				return true;
			case 'B': 
				for (int i=0; i < numCopies; i++) items.add(new Book(this, false));
				this.numCopies += numCopies;
				return true;
			case 'S': 
				for (int i=0; i < numCopies; i++) items.add(new Book(this, true));
				this.numCopies += numCopies;
				return true;
			case 'M': 
				for (int i=0; i < numCopies; i++) items.add(new Magazine(this));
				this.numCopies += numCopies;
				return true;
			case 'R': 
				for (int i=0; i < numCopies; i++) items.add(new RefBook(this));
				this.numCopies += numCopies;
				return true;
		}
		return false;
	}
	
	public boolean removeItem(int itemID) {
		for (Item item:items) 
			if(item.getIdentifier() == itemID) {
				items.remove(item);
				this.numCopies--;
				return true;
			}
		return false;
	}
	
	public Loanable getAvailableLoanableCopie() {
		if (!this.isLoanable()) return null;
		for (Item item:items) if(item.getStatus().equals("available")) return (Loanable)item;
		return null;
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
	/*
	public int getNumOfLoans() {
		return this.numOfLoans;
	}

	public void incNumOfLoans() {
		this.numOfLoans += 1;
		
	}
	
	public void decNumOfLoans() {
		this.numOfLoans -= 1;
		assert(this.numOfLoans >= 0):"INVALID NUMBER OF LOANS";
	}
	*/
	public void listAllItems() {
		for (Item item:items) System.out.println(item);
	}
	
	public boolean requestTitle(Patron patron) {
		if (isTitleAlreadyRequested(patron)) return false;
		patrons.add(patron);
		return true;
	}

	public Patron requestedTitlePrioryPatron() {
		if (patrons.isEmpty()) return null;
		return patrons.get(0);
	}
	
	public boolean removeRequest(Patron patron) {
		return patrons.remove(patron);
	}
	
	public boolean isTitleAlreadyRequested(Patron patron) {
		return patrons.contains(patron);
	}
	
	public boolean isRequestExists() {
		return !patrons.isEmpty();
	}
	
	public boolean isRequestExists(Patron patron) {
		return patrons.contains(patron);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (title: ");
		result.append(this.title);
		result.append(", type: ");
		result.append(this.type);
		result.append(", value: ");
		result.append(this.value);
		result.append(", numCopies: ");
		result.append(this.numCopies);
		//result.append(", numOfLoans: ");
		//result.append(numOfLoans);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if (o != null && o instanceof Title) {
			Title other = (Title)o;
			result = (this.isbn == other.isbn);
		}
			
		return result;
	}

}
