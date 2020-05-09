package ca.udacity.oopInJava.exercise1;

public class ContactsManager {
	
	private Contact[] myFriends;
	private int friendsCount;
	
	ContactsManager(){
		this.friendsCount = 0;
		this.myFriends = new Contact[500];
	}
	
	public void addContact(Contact contact) {
		myFriends[friendsCount++] = contact;
	}
	
	public Contact searchContact(String name) {
		for(int i = 0; i < friendsCount; i++) {
			if (myFriends[i].getContactName().equals(name)) return myFriends[i];
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception{
		
		// use Contact(name, email, phoneNumber)
		ContactsManager contactsManager = new ContactsManager();
		contactsManager.addContact(new Contact("Adda", "", "123456789"));
		contactsManager.addContact(new Contact("Saoud", "", "456789123"));
		contactsManager.addContact(new Contact("Rougi", "", "789456123"));
		contactsManager.addContact(new Contact("Chafiq", "", "894567123"));
		contactsManager.addContact(new Contact("Sadeq", "", "234567891"));
		System.out.println(contactsManager.searchContact("Sadeq").getContactPhone());
			
	}
	

}
