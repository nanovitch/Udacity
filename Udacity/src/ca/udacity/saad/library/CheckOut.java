/**
 */
package ca.udacity.saad.library;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class CheckOut  {
	
	protected final LocalDate checkoutDate = LocalDate.now();
	protected LocalDate renewDate= LocalDate.now();
	protected LocalDate dueDate;
	protected int numRenews=0;
	protected LocalDate returnDate;
	protected final Patron patron;
	protected final Checkable item;
	
	protected CheckOut(Patron patron, Checkable item) {
		this.patron = patron;
		this.item = item;
		item.setStatus("not available");
		this.dueDate = checkoutDate.plusDays(item.getCheckoutPeriodDays());
	}
	
	public Checkable getItem() {
		return this.item;
	}
	
	public Patron getPatron() {
		return this.patron;
	}

	public LocalDate getCheckoutDate() {
		return this.checkoutDate;
	}

	public LocalDate getRenewDate() {
		return this.renewDate;
	}

	public void setRenewDate(LocalDate renewDate) {
		this.renewDate = renewDate;
		updateDueDate();
	}
	
	public void incRenews() {
		this.numRenews++;
		
	}
	
	public void decRenews() {
		this.numRenews--;
		
	}
	
	public void resetNumRenews() {
		this.numRenews = 0;
		
	}
	
	public int getNumRenews() {
		return numRenews;
	}

	public void setNumRenews(int numRenews) {
		this.numRenews = numRenews;
		
	}
	
	public LocalDate getDueDate() {
		return this.dueDate;
	}

	public void updateDueDate() {
		this.dueDate = this.renewDate.plusDays(item.getCheckoutPeriodDays());
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
		
	}

	public double calculFine() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		LocalDate toDay = LocalDate.now();
		long noOfDaysBetween = ChronoUnit.DAYS.between(toDay, dueDate);
		return (noOfDaysBetween > 0)?this.item.getFinePerDay() * (double)noOfDaysBetween:0.0;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (Patron: ");
		result.append(patron.toString());
		result.append(" (Item: ");
		result.append(item.toString());
		result.append(" (checkoutDate: ");
		result.append(checkoutDate);
		result.append(", lastRenewDate: ");
		result.append(renewDate);
		result.append(", numRenews: ");
		result.append(numRenews);
		result.append(", dueDate: ");
		result.append(dueDate);
		result.append(", returnDate: ");
		result.append(returnDate);
		
		result.append(')');
		return result.toString();
	}

}
