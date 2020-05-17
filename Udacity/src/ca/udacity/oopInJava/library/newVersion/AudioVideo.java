/**
 */
package ca.udacity.oopInJava.library.newVersion;

class AudioVideo extends Loanable {
	private static final int AUDIVIDEO_CHECK_OUT_PERIOD_DAYS = 14;
	
	AudioVideo(Title title) {
		super(title);
	}
	
	@Override
	public int getCheckoutPeriodDays() {
		return AudioVideo.AUDIVIDEO_CHECK_OUT_PERIOD_DAYS;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (CHECK_OUT_PERIOD_DAYS: ");
		result.append(AudioVideo.AUDIVIDEO_CHECK_OUT_PERIOD_DAYS);
		result.append(')');
		return result.toString();
	}
}
