package ca.udacity.oopInJava.library.newVersion;

public abstract class LoanableTitle extends Title {
	private static final int RENEWS_MAX = 1;
	
	LoanableTitle(String title, String isbn, double value, int numCopies) {
		super(title, isbn, value, numCopies);
		
	}

	@Override
	public boolean isLoanable() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public int getRenewsMax() {
		return LoanableTitle.RENEWS_MAX;
	}
	
	public Loanable getAvailableLoanableCopie() {
		for (Item item:items) if(item.getStatus().equals("available")) return (Loanable)item;
		return null;
	}
	
	public abstract int getCheckoutPeriodDays() ;

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (RENEWS_MAX: ");
		result.append(LoanableTitle.RENEWS_MAX);
		result.append(')');
		return result.toString();
	}

}
