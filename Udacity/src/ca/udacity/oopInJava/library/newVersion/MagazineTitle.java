package ca.udacity.oopInJava.library.newVersion;

public class MagazineTitle extends NoLoanableTitle {

	MagazineTitle(String title, String isbn, double value, int numCopies) {
		super(title, isbn, value, numCopies);
		for (int i=0; i < numCopies; i++) super.items.add(new Magazine(this));
	}

	
}
