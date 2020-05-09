package ca.udacity.oopInJava.bankmanager;

public class CheckingAccount extends BankAccount {
	
	private double limit;
	
	public double getLimit() {
		return this.limit;
	}
	
	public void setLimit(double limit) {
		this.limit = limit;
	}

}
