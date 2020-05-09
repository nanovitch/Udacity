package ca.udacity.oopInJava.bankmanager;

public class SavingsAccount extends BankAccount {
	
	private int numberOfTranferts;
	
	public int getLimitOfTranferts() {
		return this.numberOfTranferts;
	}
	
	public void setNumberOfTranferts(int numberOfTranferts) {
		this.numberOfTranferts = numberOfTranferts;
	}

}
