package ca.udacity.saad.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patron {
	
	static int PATRON_UNIQUE_ID = 0;
    private final int identifier = ++PATRON_UNIQUE_ID;
    private final Card card;
	protected String name;
	protected String address;
	protected String phoneNumber;
	protected String status;
	protected int age;
	
	protected List<CheckOut> checkouts = new ArrayList<CheckOut>();
	protected Library library;

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

	public boolean checkOutItem(String title) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		if (this.isChild() && this.checkouts.size() >= 5) return false; // 5 checkouts max for children
		
		// choose only available checkable items
		List<Checkable> checkables = this.library.getAvailableCheckables(title);
		if (checkables.isEmpty()) return false;
		
		int i = (int) Math.round(Math.random() * (double)(checkables.size()-1));
		Checkable checkable = checkables.get(i); // choose a random checkable item from those who match title
		this.checkouts.add(new CheckOut(this, checkable));
		
		return true;
	}
	
	public final boolean isTitleAlreadyCheckouted(String title) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		for(CheckOut checkout:checkouts) 
			if (checkout.item.getTitle().equals(title)) return true;;
		return false;
	}

	public final boolean requestTitle(String title) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		return this.library.requestTitle(this, title);
	}

	public boolean renewCheckout(int identifier) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		for(CheckOut checkout:checkouts) {
			if (checkout.getItem().getIdentifier() == identifier) {
				if (checkout.getNumRenews() > 0) return false;
				checkout.setRenewDate(LocalDate.now());
				checkout.incRenews();
				return true;
			}
		}
		return false;
	}

	public boolean returnCheckout(String title) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		for (CheckOut checkout:checkouts) 
			if (checkout.getItem().getTitle().equals(title)) {
				Checkable item = checkout.getItem();
				item.setStatus("available");
				this.checkouts.remove(checkout);
				this.library.notifyReturn(title);
				return true;
			}
		return false;	
	}
	
	public double calculTotalFine() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		double totalFine = 0;
		for (CheckOut checkout:this.checkouts) totalFine += checkout.calculFine();
		return totalFine;
	}

	public void listCheckouts() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		for(CheckOut checkout:checkouts) System.out.println(checkout.toString());
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
