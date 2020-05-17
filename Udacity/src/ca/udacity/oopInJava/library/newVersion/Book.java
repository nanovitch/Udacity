/**
 */
package ca.udacity.oopInJava.library.newVersion;

class Book extends Loanable {
	
	private static final int NOBESTSELLER_CHECK_OUT_PERIOD_DAYS = 21;
	private static final int BESTSELLER_CHECK_OUT_PERIOD_DAYS = 14;
	
	private final int CHECK_OUT_PERIOD_DAYS; // 21 days if not a bestseller otherwise 14 days.
	private boolean isBestSeller;
	private final String author;

// TODO Remove unused code found by UCDetector
// 	public Book(Title title, String author, double value, boolean isBestSeller) {
// 		super(title);
// 		this.author = author;
// 		this.isBestSeller = isBestSeller;
// 		this.CHECK_OUT_PERIOD_DAYS = (this.isBestSeller) ? Book.BESTSELLER_CHECK_OUT_PERIOD_DAYS : Book.NOBESTSELLER_CHECK_OUT_PERIOD_DAYS;
// 	}
	
	Book(Title title, boolean isBestSeller) {
		super(title);
		this.author = "";
		this.isBestSeller = isBestSeller;
		this.CHECK_OUT_PERIOD_DAYS = (this.isBestSeller) ? Book.BESTSELLER_CHECK_OUT_PERIOD_DAYS : Book.NOBESTSELLER_CHECK_OUT_PERIOD_DAYS;
	}
	
	public int getCheckoutPeriodDays() {
		return this.CHECK_OUT_PERIOD_DAYS;
	}

	public final boolean isBestSeller() {
		return this.isBestSeller;
	}

	public void setIsBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
		
	}

	public final String getAuthor() {
		return this.author;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isBestSeller: ");
		result.append(this.isBestSeller);
		result.append(", author: ");
		result.append(this.author);
		result.append(", title: ");
		result.append(this.getTitle());
		result.append(", checkOutPeriod: ");
		result.append(this.CHECK_OUT_PERIOD_DAYS);
		result.append(')');
		return result.toString();
	}
	
}
