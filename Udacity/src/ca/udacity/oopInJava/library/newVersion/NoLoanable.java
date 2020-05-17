package ca.udacity.oopInJava.library.newVersion;

abstract class NoLoanable extends Item {
	
	NoLoanable(Title title) {
		super(title, "not loanable");
	}
	
}
