/**
 */
package ca.udacity.saad.library;

public abstract class Loanable extends Item {
	private static final int RENEWS_MAX = 1;
	private final double value;
	private double finePerDay=0.10;
	private int numOfLoans = 0;
	
	public Loanable(Title title, double value) {
		super(title, "available");
		this.value = value;
		if (this.finePerDay > value) this.finePerDay = value;
	}
	
	public int getRenewsMax() {
		return Loanable.RENEWS_MAX;
	}
	
	public abstract int getCheckoutPeriodDays() ;

	public double getValue() {
		return value;
	}

	public double getFinePerDay() {
		return finePerDay;
	}

	public void setFinePerDay(double finePerDay) {
		this.finePerDay = (finePerDay > this.value)?this.value:finePerDay;
		
	}
	
	public int getNumOfLoans() {
		return this.numOfLoans;
	}

	public void incNumOfLoans() {
		this.numOfLoans += 1;
		
	}
	
	public void decNumOfLoans() {
		this.numOfLoans -= 1;
		assert(this.numOfLoans >= 0):"INVALID NUMBER OF LOANS";
	}
	
	@Override
	public boolean isCheckable() {
		return true;
	}
	
	protected abstract Item copy();

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(", value: ");
		result.append(value);
		result.append(", finePerDay: ");
		result.append(finePerDay);
		result.append(')');
		return result.toString();
	}

}
