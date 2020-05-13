package ca.udacity.saad.library;

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
	
	public boolean isUniqueLoan(String title) {
		for (Loan loan:this.loans) if (loan.getTitle().equals(title)) return false;
		return true;
	}

	public boolean checkOutItem(String title) {
		if (this.isChild() && this.loans.size() >= 5) return false; // 5 checkouts max for children
		
		// check if a copy is available
		Loanable copie = this.library.getAvailableCopie(title);
		
		//System.out.println("getAvailableCopie: " + copie);
		
		if (copie == null) return false;
		
		//System.out.println("isUniqueLoan: " + isUniqueLoan(title));
		
		// check that item not already loaned
		if (!this.isUniqueLoan(title)) return false;
		
				
		this.loans.add(new Loan(this, copie));
		copie.incNumOfLoans();
		copie.setStatus("loaned");
		return true;
	}
	
	public final boolean requestTitle(String title) {
		return this.library.requestTitle(this, title);
	}

	public boolean renewCheckout(int identifier) {
		for(Loan loan:loans) {
			Loanable item = loan.getItem();
			if (item.getIdentifier() == identifier) {
				if (loan.getNumRenews() >= item.getRenewsMax()) return false;
				if (this.library.isTitleAlreadyRequested(this, item.getTitle())) return false;
				loan.setRenewDate(LocalDate.now());
				loan.incRenews();
				return true;
			}
		}
		return false;
	}

	public boolean returnCheckout(String title) {
		for (Loan loan:loans) 
			if (loan.getItem().getTitle().equals(title)) {
				Loanable item = loan.getItem();
				this.loans.remove(loan);
				item.setStatus("available");
				item.decNumOfLoans();
				this.library.returnNotification(title, this);
				return true;
			}
		return false;	
	}
	
	public double calculTotalFine() {
		double totalFine = 0;
		for (Loan loan:this.loans) totalFine += loan.calculFine();
		return totalFine;
	}

	public void listCheckouts() {
		for(Loan checkout:loans) System.out.println(checkout.toString());
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
