package ca.udacity.oopInJava.exercise1;

public class Contact {
	
	private String name;
	private String email;
	private String phoneNumber;
	
	Contact(String name, String email, String phoneNumber){
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getContactName() {
		return this.name;
	}
	
	public String getContactEmail() {
		return this.email;
	}
	
	public String getContactPhone() {
		return this.phoneNumber;
	}

}
