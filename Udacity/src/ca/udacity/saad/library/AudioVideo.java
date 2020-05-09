/**
 */
package ca.udacity.saad.library;

public class AudioVideo extends Checkable {
	
	protected static final int CHECK_OUT_PERIOD_DAYS = 14;
	
	protected AudioVideo(String title, double value) {
		super(title, value, CHECK_OUT_PERIOD_DAYS);
	}
	
	public Item copy() {
		return new AudioVideo(this.title, this.value);
	}

	
}
