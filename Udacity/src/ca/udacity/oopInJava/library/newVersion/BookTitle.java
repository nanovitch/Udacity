package ca.udacity.oopInJava.library.newVersion;

public class BookTitle extends LoanableTitle {
	private static final int NOBESTSELLER_CHECK_OUT_PERIOD_DAYS = 21;
	private static final int BESTSELLER_CHECK_OUT_PERIOD_DAYS = 14;
	
	private final int CHECK_OUT_PERIOD_DAYS; // 21 days if not a bestseller otherwise 14 days.
	private boolean isBestSeller;
	private final String author;
	
	BookTitle(String title, String isbn, double value, int numCopies, boolean isBestSeller) {
		super(title, isbn, value, numCopies);
		this.isBestSeller = isBestSeller;
		this.author = "";
		this.CHECK_OUT_PERIOD_DAYS = (this.isBestSeller) ? BookTitle.BESTSELLER_CHECK_OUT_PERIOD_DAYS : BookTitle.NOBESTSELLER_CHECK_OUT_PERIOD_DAYS;
		for (int i=0; i < numCopies; i++) super.items.add(new Book(this, isBestSeller));
	}
	
	public boolean isBestSeller() {
		return this.isBestSeller;
	}
	
	public final String getAuthor() {
		return this.author;
	}
	
	@Override
	public int getCheckoutPeriodDays() {
		// TODO Auto-generated method stub
		return this.CHECK_OUT_PERIOD_DAYS;
	}

}
