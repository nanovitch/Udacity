package ca.udacity.saad.library;

public class RefBook extends NoLoanable {
	protected RefBook(Title title) {
		super(title);
	}
	
	protected Item copy() {
		return new RefBook(this.title);
	}
}
