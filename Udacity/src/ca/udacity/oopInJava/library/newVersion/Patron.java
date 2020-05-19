package ca.udacity.oopInJava.library.newVersion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class Patron {
	
	private static final int VALIDITY_PERIOD_YEARS = 1;
	private static int PATRON_UNIQUE_ID = 0;
	
    private final int ID = ++PATRON_UNIQUE_ID;
    private final Card card;
    private final String name;
    private String address;
    private String phoneNumber;
    private String status = "created";
    //private int age;
    private final LocalDate birthDate;

    private List<Loan> loans = new ArrayList<Loan>();
    private Library library;

// TODO Remove unused code found by UCDetector
// 	Patron(String name, String address, String phoneNumber, LocalDate birthDate, Library library) {
// 		this.name = name;
// 		this.address = address;
// 		this.phoneNumber = phoneNumber;
// 		this.status = "created";
// 		this.birthDate = birthDate;
// 		this.library = library;
// 		this.card = new Card(this);
// 	}

	Patron(LocalDate birthDate, Library library) {
		this.name = "";
		this.address = "";
		this.phoneNumber = "";
		this.status = "created";
		this.birthDate = birthDate;
		this.library = library;
		this.card = new Card(this);
	}

	/*
	 * // Enforce specified precondition in public method
         if (rate <= 0 || rate > MAX_REFRESH_RATE)
             throw new IllegalArgumentException("Illegal rate: " + rate);
	 */

	public int getValidityPeriod() {
		return Patron.VALIDITY_PERIOD_YEARS;
	}
	
// TODO Remove unused code found by UCDetector
// 	public boolean isItemActuallyLoaned(Loanable item) {
// 		for (Loan loan:this.loans) if (loan.getItem() == item) return true;
// 		return false;
// 	}

	boolean checkOutItem(Loanable item) {

		if (item == null) return false;
		
		// check that loaner is active
		if (this.getStatus() != "active") return false;

		// check that item is available
		if (!item.getStatus().equals("available")) return false;

		// 5 checkouts max for children
		if (this.isChild() && this.loans.size() >= 5) return false; 

		// check that item is not already loaned
		//if (this.isItemActuallyLoaned(item)) return false; // if yes the item cannot be available!

		// check that item Title is not already requested by someone else with higher priority
		Title title = item.getTitleObject();
		Patron prioryRequester = title.requestedTitlePrioryPatron();
		if (prioryRequester != null && prioryRequester != this) return false;

		// remove the requests's record if exists
		boolean isRequestCleared = true;
		if (prioryRequester == this) isRequestCleared = title.removeRequest(this);
		if (!isRequestCleared) return false;


		this.loans.add(new Loan(this, item));
		//item.getTitleObject().incNumOfLoans();
		item.setStatus("loaned");
		return true;

	}

	final boolean requestTitle(Title title) {
		if (title == null) return false;
		return title.requestTitle(this);
	}

// TODO Remove unused code found by UCDetector
// 	public boolean renewCheckout(Loanable item) {
// 		for(Loan loan:this.loans) {
// 			if (loan.getItem() == item) {
// 				if (loan.getNumRenews() >= item.getRenewsMax()) return false;
// 				loan.setRenewDate(LocalDate.now());
// 				loan.incRenews();
// 				return true;
// 			}
// 		}
// 		return false;
// 	}
	// probably that we have to archive a loan, especially that with due fines, before destroy it 
	boolean returnCheckout(Loanable item) {
		if (item == null) return false;
		for (Loan loan:this.loans) 
			if (loan.getItem() == item) {
				this.loans.remove(loan);
				item.setStatus("available");
				//item.getTitleObject().decNumOfLoans();
				this.library.returnNotification(item, this);
				return true;
			}
		return false;	
	}

// TODO Remove unused code found by UCDetector
// 	public double calculTotalFine() {
// 		double totalFine = 0;
// 		for (Loan loan:this.loans) totalFine += loan.calculFine();
// 		return totalFine;
// 	}

	void listLoans() {
		for(Loan loan:this.loans) System.out.println(loan);
	}

	public final int getID() {
		return this.ID;
	}

	public final boolean isChild() {
		return getAge() <= 12;
	}

	public final String getName() {
		return this.name;
	}

	public final String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;

	}

	public final String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;

	}

	public final String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;

	}

	public final int getAge() {
		LocalDate today= LocalDate.now();
		return today.getYear()- this.birthDate.getYear();
	}
	
	//public final int getAge() {
	//	return this.age;
	//}

	public final Card getCard() {
		return this.card;
	}
	
	public int getNumOfLoans() {
		return this.loans.size();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (ID: ");
		result.append(this.ID);
		result.append(" (name: ");
		result.append(this.name);
		result.append(", address: ");
		result.append(this.address);
		result.append(", phoneNumber: ");
		result.append(this.phoneNumber);
		result.append(", status: ");
		result.append(this.status);
		result.append(", isChild?: ");
		result.append(this.isChild());
		result.append(')');
		return result.toString();
	}
	
	
}