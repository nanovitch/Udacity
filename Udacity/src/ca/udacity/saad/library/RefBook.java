package ca.udacity.saad.library;

public class RefBook extends NoCheckable {
	protected RefBook(String title) {
		super(title);
	}
	
	public Item copy() {
		return new RefBook(this.title);
	}
}
