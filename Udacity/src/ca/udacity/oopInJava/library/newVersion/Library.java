/**
 */
package ca.udacity.oopInJava.library.newVersion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Library {
	private String name = "";// add a library name if needed
	private List<Patron> patrons = new ArrayList<Patron>();
	//private List<Item> items = new ArrayList<Item>();
	private List<Title> titles = new ArrayList<Title>();
	private HashMap<Patron, Title> requests = new LinkedHashMap<Patron, Title>(); // this map should behave like a Queue
		
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
	
	public boolean addTitle(Title title) {
		if (title == null) return false;
		return this.titles.add(title);
	}
	
	public boolean removeTitle(Title title) {
		if (title == null) return false;
		return this.titles.remove(title);
	}
	
	public boolean removeItem(Item item) {
		Title title = item.getTitleObject();
		if (title == null) return false;
		return title.removeItem(item.getIdentifier());
	}

	public boolean isTitleExists(String title) {
		for (Title t : titles) if(t.getTitle().equals(title)) return true;
		return false;
	}

	public void listAllPatrons() {
		for(Patron patron:patrons) System.out.println(patron.toString());
	}

	public void listAllTitles() {
		for(Title title:titles) System.out.println(title.toString());
	}
	
	public void listAllItems() {
		for(Title title:titles) title.listAllItems();
	}
	
	public void listAllLoans() {
		for(Patron patron:patrons) patron.listLoans();;
	}
	
	public boolean isTitleAlreadyRequested(Title title, Patron patron) {
		return requests.containsKey(patron) && requests.containsValue(title);
	}
	
	public boolean isTitleObjectExists(Title title) {
		for (Title t : titles) if(t == title) return true;
		return false;
	}
	
	private int numRequestsTitle(Title title) {
		int numReq = 0;
		for (Title t : titles) if(t == title) numReq++;
		return numReq;
	}
	
	public boolean requestTitle(Patron patron, Title title) {
		assert(this.patrons.contains(patron)):"Requester not in our database!!!";
		if (isTitleAlreadyRequested(title, patron)) return false;
		requests.put(patron, title);
		return true;
	}
	
	public Patron requestedTitlePrioryPatron(Title title) {
		Patron prioryRequester = null;
		for(Map.Entry<Patron, Title> entry : this.requests.entrySet()) {
			if (entry.getValue() == title) {
				prioryRequester = entry.getKey();
				break;
			}
		}
		return prioryRequester;
	}
	
	// automatically called by a successful call of the Patron "returnCheckout" method
	public boolean returnNotification(Loanable item, Patron patron) {
		if (!requests.containsValue(item.getTitleObject())) return false;
		Patron requester = null;
		Title title = item.getTitleObject();
		for(Map.Entry<Patron, Title> entry : this.requests.entrySet()) {
			if (entry.getValue() == title) {
				requester = entry.getKey();
				break;
			}
		}
		//if (requester == null) return false; // title is not requested by any => impossible the requested Title is in the requests collection
		assert(requester != patron):"ABNORMAL EXPECTED CALL!!!"; // avoid any abnormal cycle
		requests.remove(requester, title);
		return requester.checkOutItem(item);
	}
	
	// automatically called by a successful call of the Patron "returnCheckout" method
		public boolean removeRequest(Patron patron, Title title) {
			return requests.remove(patron, title);
		}

} 
