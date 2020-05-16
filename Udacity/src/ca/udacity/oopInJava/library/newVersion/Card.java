/**
 */
package ca.udacity.oopInJava.library.newVersion;

import java.time.LocalDate;

public class Card {
	private static final int VALIDITY_PERIOD_YEARS = 1;
	
	private final Patron patron;
	private LocalDate renewDate= LocalDate.ofYearDay(LocalDate.now().getYear() + Card.VALIDITY_PERIOD_YEARS, LocalDate.now().getDayOfYear());
	
	protected Card(Patron patron) {
		this.patron = patron;
	}

	public int getCardNumber() {
		return this.patron.getID();
	}
	
	public LocalDate getRenewDate() {
		return this.renewDate;
	}
	
	public void setRenewDate(LocalDate renewDate) {
		this.renewDate = renewDate;
	}
	
	public String getStatus() {
		return this.patron.getStatus();
	}
	

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (cardNumber: ");
		result.append(this.getCardNumber());
		result.append(')');
		return result.toString();
	}

}
