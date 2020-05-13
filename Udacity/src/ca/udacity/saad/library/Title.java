package ca.udacity.saad.library;

public class Title {
	private final String title;
	private int numCopies = 0;
	
	public Title(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void incNumCopies() {
		this.numCopies++;
	}
	
	public void decNumCopies() {
		this.numCopies--;
	}
	
	public int getNumCopies() {
		return this.numCopies++;
	}

}
