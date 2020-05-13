/**
 */
package ca.udacity.saad.library;

public class AudioVideo extends Loanable {
	
	protected final int CHECK_OUT_PERIOD_DAYS = 14;
	
	public AudioVideo(Title title, double value) {
		super(title, value);
	}
	
	protected Item copy() {
		return new AudioVideo(this.title, this.getValue());
	}

	@Override
	public int getCheckoutPeriodDays() {
		return CHECK_OUT_PERIOD_DAYS;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(", title: ");
		result.append(this.getTitle());
		result.append(", status: ");
		result.append(this.status);
		result.append(" (checkOutPeriod: ");
		result.append(CHECK_OUT_PERIOD_DAYS);
		result.append(')');
		return result.toString();
	}
}
