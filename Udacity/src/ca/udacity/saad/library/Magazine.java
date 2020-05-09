package ca.udacity.saad.library;

public class Magazine extends NoCheckable {
	protected Magazine(String title) {
		super(title);
	}
	
	public Item copy() {
		return new Magazine(this.title);
	}

} 
