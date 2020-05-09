package ca.udacity.oopInJava.bankmanager;

import java.util.Date;

public class CertificateOfDeposit extends BankAccount {
	
	private Date expiryDate;
	
	public Date getExpiryDate() {
		return this.expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
