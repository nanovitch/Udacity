package ca.udacity.oopInJava.library.newVersion;

import java.util.ArrayList;
import java.util.List;

public class Title {
	private final String title;
	private int numCopies;
	private double value;
	private double finePerDay=0.10;
	private char type;
	//private int numOfLoans = 0;
	List<Item> items = new ArrayList<Item>();
	
	public Title(String title, char type, double value, int numCopies) /*throws Exception*/ {
		this.title = title;
		this.value = value;
		if (this.finePerDay > value) this.finePerDay = value;
		switch (type) {
		case 'A': // AudioVideo
			for (int i=0; i < numCopies; i++) items.add(new AudioVideo(this));
			break;
		case 'B': // Book
			for (int i=0; i < numCopies; i++) items.add(new Book(this, value, false));
			break;
		case 'S': // BestSeller
			for (int i=0; i < numCopies; i++) items.add(new Book(this, value, true));
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
				for (int i=0; i < numCopies; i++) items.add(new Book(this, value, false));
				this.numCopies += numCopies;
				return true;
			case 'S': 
				for (int i=0; i < numCopies; i++) items.add(new Book(this, value, true));
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
		for (Item item:items) System.out.println(item.toString());
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

}
