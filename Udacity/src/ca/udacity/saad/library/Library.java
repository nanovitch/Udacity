/**
 */
package ca.udacity.saad.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
	protected List<Patron> patrons = new ArrayList<Patron>();
	protected List<Item> items = new ArrayList<Item>();
	
	/**
	 * Container of active requests about items not yet available.
	 * Need of compute a timer to check if an item became available and notify the requester.
	 */
	private HashMap<Patron, String> requests = new HashMap<Patron, String>(); 
	
	public List<Checkable> getAvailableCheckables(String title){
		List<Checkable> checkables = new ArrayList<Checkable>();
		for (Item item:items) if (item.isCheckable() && item.getStatus() == "available" && item.getTitle().equals(title)) checkables.add((Checkable)item);
		return checkables;
	}
	
	
	public boolean addPatron(Patron patron) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		if (patron == null) return false;
		patrons.add(patron);
		return true;
	}

	public boolean removePatron(Patron patron) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		if (!this.patrons.contains(patron)) return false;
		patrons.remove(patron);
		return true;
	}
	
	public boolean suspendPatron(Patron patron) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		if (!this.patrons.contains(patron)) return false;
		patron.setStatus("suspended");
		return true;
	}
	
	public boolean resetPatronStatus(Patron patron) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		if (!this.patrons.contains(patron)) return false;
		patron.setStatus("active");
		return true;
	}
	
	public Checkable getCheckable(String title) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		for (Item item:items) if (item.getTitle().equals(title) && item.getStatus() == "available") return (Checkable)item;
		return null;
	}

	public boolean addItem(Item item, int numCopies) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		if (item == null) return false;
		items.add(item);
		if (numCopies > 1) for (int i=0; i<numCopies; i++) items.add(item.copy());
		return true;
	}

	public boolean removeItem(Item item) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		if (!this.items.contains(item)) return false;
		items.remove(item);
		return true;
	}

	public void listAllPatrons() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		for(Patron patron:patrons) System.out.println(patron.toString());
	}

	public void listAllItems() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		for(Item item:items) System.out.println(item.toString());
	}
	
	public boolean isTitleAlreadyRequested(Patron patron, String title) {
		for (Map.Entry<Patron, String> entry : requests.entrySet())  
            if (entry.getKey() == patron && entry.getValue().equals(title)) return true; 
		return false;
		
	}
	
	public boolean requestTitle(Patron patron, String title) {
		if (patron == null || title == null || !this.patrons.contains(patron) || patron.isTitleAlreadyCheckouted(title) || isTitleAlreadyRequested(patron, title)) return false;
		requests.put(patron, title);
		return true;
	}
	// library looks if there is a request for the returned title
	// and if so, do the check out for the requester
	public boolean notifyReturn(String title) {
		//check if returned item has a title that is requested
		if (!this.requests.containsValue(title)) return false;
		Patron patron = null;
		for(Map.Entry<Patron, String> entry : this.requests.entrySet()) {
			if (entry.getValue().equals(title)) {
				patron = entry.getKey();
				break;
			}
		}
		if (patron == null) return false;
		return patron.checkOutItem(title);
	}

} 
