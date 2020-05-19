/**
 * CheckOut is a temporary object. 
 * It must be destroyed or archived as soon as the loaned item was returned (e.g, the returnDate was set).
 */
package ca.udacity.oopInJava.library.newVersion;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

class Loan  {
	
	private final LocalDate checkoutDate = LocalDate.now();
	private LocalDate renewDate= LocalDate.now();
	private LocalDate dueDate;
	private int numRenews=0;
	private LocalDate returnDate = null;
	private final Patron patron;
	private final Loanable item;
	
	Loan(Patron patron, Loanable item) {
		this.patron = patron;
		this.item = item;
		item.setStatus("not available");
		this.dueDate = checkoutDate.plusDays(item.getCheckoutPeriodDays());
	}
	
	public Loanable getItem() {
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
	
	public String getTitle() {
		// debug
		assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
		
		return this.item.getTitle();
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
	
	void incRenews() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		this.numRenews++;
		
	}
	
// TODO Remove unused code found by UCDetector
// 	public void decRenews() {
// 		// debug
// 			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
// 		//  debug end
// 				
// 		this.numRenews--;
// 		
// 	}
	
// TODO Remove unused code found by UCDetector
// 	public void resetNumRenews() {
// 		// debug
// 			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
// 		//  debug end
// 				
// 		this.numRenews = 0;
// 		
// 	}
	
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

	private void updateDueDate() {
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

	double calculFine() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		LocalDate toDay = LocalDate.now();
		long noOfDaysBetween = ChronoUnit.DAYS.between(toDay, dueDate);
		double finePerDay = this.item.getTitleObject().getFinePerDay();
		
		return (noOfDaysBetween > 0) ? (finePerDay * noOfDaysBetween) : 0.0;
	}

	@Override
	public String toString() {
		// debug
			assert(this.returnDate == null):"ABNORMAL OPERATION!!! Object normally waiting to be garbage collected.";
		//  debug end
				
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (Patron: ");
		result.append(patron);
		result.append(", Item: ");
		result.append(item);
		result.append(", checkoutDate: ");
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
