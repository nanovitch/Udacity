/**
 */
package ca.udacity.oopInJava.library.newVersion;

public class AudioVideo extends Loanable {
	
	protected final int CHECK_OUT_PERIOD_DAYS = 14;
	
	public AudioVideo(Title title) {
		super(title);
	}
	
	@Override
	public int getCheckoutPeriodDays() {
		return CHECK_OUT_PERIOD_DAYS;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (CHECK_OUT_PERIOD_DAYS: ");
		result.append(this.CHECK_OUT_PERIOD_DAYS);
		result.append(')');
		return result.toString();
	}
}
