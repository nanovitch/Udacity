/**
 */
package ca.udacity.saad.library;

public class AudioVideo extends Checkable {
	
	protected final int CHECK_OUT_PERIOD_DAYS = 14;
	
	protected AudioVideo(String title, double value) {
		super(title, value);
	}
	
	public Item copy() {
		return new AudioVideo(this.title, this.value);
	}

	@Override
	public int getCheckoutPeriodDays() {
		return CHECK_OUT_PERIOD_DAYS;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(", title: ");
		result.append(this.title);
		result.append(", status: ");
		result.append(this.status);
		result.append(" (checkOutPeriod: ");
		result.append(CHECK_OUT_PERIOD_DAYS);
		result.append(')');
		return result.toString();
	}
}
