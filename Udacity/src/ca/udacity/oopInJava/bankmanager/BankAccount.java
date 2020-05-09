package ca.udacity.oopInJava.bankmanager;

public class BankAccount {
	
	private String accountNumber;
	private double balance;
	
	public String getaccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setaccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
