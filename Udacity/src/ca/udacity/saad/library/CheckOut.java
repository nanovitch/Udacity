/**
 * CheckOut is a temporary object. 
 * It must be destroyed or archived as soon as the loaned item was returned (e.g, the returnDate was set).
 */
package ca.udacity.saad.library;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class CheckOut  {
	
	protected final LocalDate checkoutDate = LocalDate.now();
	protected LocalDate renewDate= LocalDate.now();
	protected LocalDate dueDate;
	protected int numRenews=0;
	protected LocalDate returnDate = null;
	protected final Patron patron;
	protected final Checkable item;
	
	protected CheckOut(Patron patron, Checkable item) {
		this.patron = patron;
		this.item = item;
		item.setStatus("not available");
		this.dueDate = checkoutDate.plusDays(item.getCheckoutPeriodDays());
	}
	
	public Checkable getItem() {
		// debug
		assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
		
		return this.item;
	}
	
	public Patron getPatron() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
			
		return this.patron;
	}

	public LocalDate getCheckoutDate() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
		
		return this.checkoutDate;
	}

	public LocalDate getRenewDate() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		return this.renewDate;
	}

	public void setRenewDate(LocalDate renewDate) {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		this.renewDate = renewDate;
		updateDueDate();
	}
	
	public void incRenews() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		this.numRenews++;
		
	}
	
	public void decRenews() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		this.numRenews--;
		
	}
	
	public void resetNumRenews() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		this.numRenews = 0;
		
	}
	
	public int getNumRenews() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		return numRenews;
	}

	public void setNumRenews(int numRenews) {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		this.numRenews = numRenews;
		
	}
	
	public LocalDate getDueDate() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		return this.dueDate;
	}

	public void updateDueDate() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		this.dueDate = this.renewDate.plusDays(item.getCheckoutPeriodDays());
	}

	public LocalDate getReturnDate() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		return returnDate;
	}
	
	public void setReturnDate(LocalDate returnDate) {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		this.returnDate = returnDate;
		
	}

	public double calculFine() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		LocalDate toDay = LocalDate.now();
		long noOfDaysBetween = ChronoUnit.DAYS.between(toDay, dueDate);
		return (noOfDaysBetween > 0)?this.item.getFinePerDay() * (double)noOfDaysBetween:0.0;
	}

	@Override
	public String toString() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
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
