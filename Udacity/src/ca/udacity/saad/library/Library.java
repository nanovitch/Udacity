/**
 */
package ca.udacity.saad.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
	private String name = "";// add a library name if needed
	private List<Patron> patrons = new ArrayList<Patron>();
	private List<Item> items = new ArrayList<Item>();
	private List<Title> titles = new ArrayList<Title>();
	private HashMap<Patron, String> requests = new HashMap<Patron, String>(); 
	
	public boolean addPatron(Patron patron) {
		if (patron == null) return false;
		patrons.add(patron);
		return true;
	}

	public boolean removePatron(Patron patron) {
		if (!this.patrons.contains(patron)) return false;
		patrons.remove(patron);
		return true;
	}
	
	public boolean suspendPatron(Patron patron) {
		if (!this.patrons.contains(patron)) return false;
		patron.setStatus("suspended");
		return true;
	}
	
	public boolean resetPatronStatus(Patron patron) {
		if (!this.patrons.contains(patron)) return false;
		patron.setStatus("active");
		return true;
	}
	
	public boolean addItem(Item item, int numCopies) {
		if (item == null || numCopies < 1) return false;
		this.items.add(item);
		// creating additional copies
		for (int i=1; i<numCopies; i++) items.add(item.copy());
		return true;
	}
	
	public boolean removeItem(Item item) {
		if (!this.items.contains(item)) return false;
		items.remove(item);
		item.decNumCopies();
		return true;
	}

	public Loanable getAvailableCopie(String title) {
		for (Item item:this.items) {
			//System.out.println("isCheckable, getStatus, title, NumCopies: " + item.isCheckable() + ", " + item.getStatus() + ", " + item.getTitle() + ", " + item.getNumCopies());
			//if (item.isCheckable()) System.out.println( ", " + ((Checkable)item).getNumOfLoans());
			if (item.isCheckable() && item.getStatus().equals("available") && item.getTitle().equals(title) && item.getNumCopies() > ((Loanable)item).getNumOfLoans())
				return (Loanable)item;
			
		}
		return null;
	}
	
	public boolean isTitleExists(String title) {
		for (Title t : titles) if(t.getTitle().equals(title)) return true;
		return false;
	}

	public void listAllPatrons() {
		for(Patron patron:patrons) System.out.println(patron.toString());
	}

	public void listAllItems() {
		for(Item item:items) System.out.println(item.toString());
	}
	
	public boolean isTitleAlreadyRequested(Patron patron, String title) {
		for (Map.Entry<Patron, String> entry : requests.entrySet())  
            if (entry.getKey() == patron && entry.getValue().equals(title)) return true; 
		return false;
		
	}
	
	public boolean requestTitle(Patron patron, String title) {
		if (patron == null || title == null || !this.patrons.contains(patron) || !patron.isUniqueLoan(title) || isTitleAlreadyRequested(patron, title)) return false;
		requests.put(patron, title);
		return true;
	}
	
	// automatically called by a successful call of the Patron "returnCheckout" method
	public boolean returnNotification(String title, Patron patron) {
		Patron requester = null;
		for(Map.Entry<Patron, String> entry : this.requests.entrySet()) {
			if (entry.getValue().equals(title)) {
				requester = entry.getKey();
				break;
			}
		}
		if (requester == null) return false; // title is not requested by any
		assert(requester != patron):"ABNORMAL EXPECTED CALL!!!"; // avoid any abnormal cycle
		return requester.checkOutItem(title);
	}

} 
