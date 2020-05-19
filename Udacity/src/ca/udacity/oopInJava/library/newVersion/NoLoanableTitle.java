package ca.udacity.oopInJava.library.newVersion;

public class NoLoanableTitle extends Title {

	NoLoanableTitle(String title, String isbn, double value, int numCopies) {
		super(title, isbn, value, numCopies);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isLoanable() {
		// TODO Auto-generated method stub
		return false;
	}

}
