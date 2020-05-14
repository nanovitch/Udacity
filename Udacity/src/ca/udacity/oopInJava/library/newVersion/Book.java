/**
 */
package ca.udacity.oopInJava.library.newVersion;

public class Book extends Loanable {
	
	private static final int NOBESTSELLER_CHECK_OUT_PERIOD_DAYS = 21;
	private static final int BESTSELLER_CHECK_OUT_PERIOD_DAYS = 14;
	
	private final int CHECK_OUT_PERIOD_DAYS; // 21 days if not a bestseller otherwise 14 days.
	private boolean isBestSeller;
	private final String isbn;
	private final String author;

	public Book(Title title, String isbn, String author, double value, boolean isBestSeller) {
		super(title);
		this.isbn = isbn;
		this.author = author;
		this.isBestSeller = isBestSeller;
		this.CHECK_OUT_PERIOD_DAYS = (this.isBestSeller) ? BESTSELLER_CHECK_OUT_PERIOD_DAYS : NOBESTSELLER_CHECK_OUT_PERIOD_DAYS;
	}
	
	public Book(Title title, double value, boolean isBestSeller) {
		super(title);
		this.isbn = "";
		this.author = "";
		this.isBestSeller = isBestSeller;
		this.CHECK_OUT_PERIOD_DAYS = (this.isBestSeller) ? 14 : 21;
	}
	
	public int getCheckoutPeriodDays() {
		return CHECK_OUT_PERIOD_DAYS;
	}

	public final boolean isBestSeller() {
		return isBestSeller;
	}

	public void setIsBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
		
	}

	public final String getIsbn() {
		return isbn;
	}

	public final String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isBestSeller: ");
		result.append(this.isBestSeller);
		result.append(", isbn: ");
		result.append(this.isbn);
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
