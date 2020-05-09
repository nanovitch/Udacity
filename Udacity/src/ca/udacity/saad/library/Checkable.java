/**
 */
package ca.udacity.saad.library;

public abstract class Checkable extends Item {
	protected final int CHECK_OUT_PERIOD_DAYS;
	protected final int RENEWS_MAX = 1;
	protected final double value;
	protected double finePerDay=0.10;
	
	protected Checkable(String title, double value, int CHECK_OUT_PERIOD_DAYS) {
		super(title, "available");
		this.value = value;
		this.CHECK_OUT_PERIOD_DAYS = CHECK_OUT_PERIOD_DAYS;
		if (this.finePerDay > value) this.finePerDay = value;
	}
	
	public int getRenewsMax() {
		return this.RENEWS_MAX;
	}
	
	public int getCheckoutPeriodDays() {
		return CHECK_OUT_PERIOD_DAYS;
	}

	public double getValue() {
		return value;
	}

	public double getFinePerDay() {
		return finePerDay;
	}

	public void setFinePerDay(double finePerDay) {
		this.finePerDay = (finePerDay > this.value)?this.value:finePerDay;
		
	}
	
	@Override
	public boolean isCheckable() {
		return true;
	}
	
	public abstract Item copy();

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (checkOutPeriod: ");
		result.append(CHECK_OUT_PERIOD_DAYS);
		result.append(", value: ");
		result.append(value);
		result.append(", finePerDay: ");
		result.append(finePerDay);
		result.append(')');
		return result.toString();
	}

}
