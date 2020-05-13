package ca.udacity.saad.library;

public class Magazine extends NoLoanable {
	public Magazine(Title title) {
		super(title);
	}
	
	protected Item copy() {
		return new Magazine(this.title);
	}

} 
