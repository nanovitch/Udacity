/**
 */
package ca.udacity.saad.library;

public class Book extends Checkable {
	
	protected static final int CHECK_OUT_PERIOD_DAYS = 21;
	
	protected boolean isBestSeller;
	protected final String isbn;
	protected final String author;

	protected Book(String isbn, String title, String author, double value, boolean isBestSeller) {
		super(title, value, CHECK_OUT_PERIOD_DAYS);
		this.isbn = isbn;
		this.author = author;
		this.isBestSeller = isBestSeller;
	}
	
	protected Book(String title, double value, boolean isBestSeller) {
		super(title, value, CHECK_OUT_PERIOD_DAYS);
		this.isbn = "";
		this.author = "";
		this.isBestSeller = isBestSeller;
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
	
	public Item copy() {
		return new Book(this.isbn, this.title, this.author, this.value, this.isBestSeller);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(", isbn: ");
		result.append(this.isbn);
		result.append(", author: ");
		result.append(this.author);
		result.append(", title: ");
		result.append(this.title);
		result.append(" (isBestSeller: ");
		result.append(this.isBestSeller);
		result.append(')');
		return result.toString();
	}

}
