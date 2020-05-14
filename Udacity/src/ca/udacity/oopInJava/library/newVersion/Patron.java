package ca.udacity.oopInJava.library.newVersion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patron {
	
	static int PATRON_UNIQUE_ID = 0;
    private final int identifier = ++PATRON_UNIQUE_ID;
    private final Card card;
    private String name;
    private String address;
    private String phoneNumber;
    private String status;
    private int age;
	
    private List<Loan> loans = new ArrayList<Loan>();
    private Library library;

	protected Patron(String name, String address, String phoneNumber, int age, Library library) {
		this.card = new Card(this.identifier);
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = "registered";
		this.age = age;
		this.library = library;
	}
	
	protected Patron(int age, Library library) {
		this.card = new Card(this.identifier);
		this.name = "";
		this.address = "";
		this.phoneNumber = "";
		this.status = "active";
		this.age = age;
		this.library = library;
	}
	
	/*
	 * // Enforce specified precondition in public method
         if (rate <= 0 || rate > MAX_REFRESH_RATE)
             throw new IllegalArgumentException("Illegal rate: " + rate);
	 */
	
	
	public boolean isItemActuallyLoaned(Loanable item) {
		for (Loan loan:this.loans) if (loan.getItem() == item) return true;
		return false;
	}

	public boolean checkOutItem(Loanable item) {
		
		if (item == null) return false;
		
		// check that item is available
		if (!item.getStatus().equals("available")) return false;
		
		// 5 checkouts max for children
		if (this.isChild() && this.loans.size() >= 5) return false; 
		
		// check that item is not already loaned
		//if (this.isItemActuallyLoaned(item)) return false; // if yes the item cannot be available!
		
		// check that item is not already requested by someone else with higher priority
		Patron prioryRequester = this.library.requestedTitlePrioryPatron(item.getTitleObject());
		if (prioryRequester != null && prioryRequester != this) return false;
		
		// remove the requests's record if exists
		boolean isRequestCleared = true;
		if (prioryRequester == this) isRequestCleared = this.library.removeRequest(this, item.getTitleObject());
		if (!isRequestCleared) return false;
		
						
		this.loans.add(new Loan(this, item));
		//item.getTitleObject().incNumOfLoans();
		item.setStatus("loaned");
		return true;
		
	}
	
	public final boolean requestTitle(Title title) {
		if (title == null) return false;
		return this.library.requestTitle(this, title);
	}

	public boolean renewCheckout(Loanable item) {
		for(Loan loan:loans) {
			if (loan.getItem() == item) {
				if (loan.getNumRenews() >= item.getRenewsMax()) return false;
				loan.setRenewDate(LocalDate.now());
				loan.incRenews();
				return true;
			}
		}
		return false;
	}
	// probably that we have to archive a loan, especially that with due fines, before destroy it 
	public boolean returnCheckout(Loanable item) {
		if (item == null) return false;
		for (Loan loan:loans) 
			if (loan.getItem() == item) {
				this.loans.remove(loan);
				item.setStatus("available");
				//item.getTitleObject().decNumOfLoans();
				this.library.returnNotification(item, this);
				return true;
			}
		return false;	
	}
	
	public double calculTotalFine() {
		double totalFine = 0;
		for (Loan loan:this.loans) totalFine += loan.calculFine();
		return totalFine;
	}

	public void listLoans() {
		for(Loan loan:loans) System.out.println(loan.toString());
	}
	
	public final int getID() {
		return identifier;
	}
	
	public final boolean isChild() {
		return age <= 12;
	}

	public final String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public final String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		
	}

	public final String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		
	}

	public final String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		
	}

	public final int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		
	}
	
	public final Card getCard() {
		return this.card;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (ID: ");
		result.append(this.identifier);
		result.append(" (name: ");
		result.append(this.name);
		result.append(", address: ");
		result.append(this.address);
		result.append(", phoneNumber: ");
		result.append(this.phoneNumber);
		result.append(", status: ");
		result.append(this.status);
		result.append(", age: ");
		result.append(this.age);
		result.append(')');
		return result.toString();
	}

}
