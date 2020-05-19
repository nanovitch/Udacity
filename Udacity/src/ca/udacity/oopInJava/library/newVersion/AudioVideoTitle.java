package ca.udacity.oopInJava.library.newVersion;

public class AudioVideoTitle extends LoanableTitle {
	
	private static final int AUDIVIDEO_CHECK_OUT_PERIOD_DAYS = 14;

	AudioVideoTitle(String title, String isbn, double value, int numCopies) {
		super(title, isbn, value, numCopies);
		for (int i=0; i < numCopies; i++) super.items.add(new AudioVideo(this));
	}

	@Override
	public int getCheckoutPeriodDays() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (CHECK_OUT_PERIOD_DAYS: ");
		result.append(AudioVideoTitle.AUDIVIDEO_CHECK_OUT_PERIOD_DAYS);
		result.append(')');
		return result.toString();
	}

}
