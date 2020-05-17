/**
 */
package ca.udacity.oopInJava.library.newVersion;

abstract class Loanable extends Item {
	private static final int RENEWS_MAX = 1;
	
	
	Loanable(Title title) {
		super(title, "available");
		
	}
	
	public int getRenewsMax() {
		return Loanable.RENEWS_MAX;
	}
	
	public abstract int getCheckoutPeriodDays() ;

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (RENEWS_MAX: ");
		result.append(Loanable.RENEWS_MAX);
		result.append(')');
		return result.toString();
	}

}
