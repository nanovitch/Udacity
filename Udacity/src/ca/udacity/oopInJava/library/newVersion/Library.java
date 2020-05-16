/**
 */
package ca.udacity.oopInJava.library.newVersion;

import java.util.ArrayList;
import java.util.List;


public class Library {
	private String name = "";// add a library name if needed
	private List<Patron> patrons = new ArrayList<Patron>();
	private List<Title> titles = new ArrayList<Title>();
	
	public boolean addPatron(Patron patron) {
		if (patron == null) return false;
		patrons.add(patron);
		patron.setStatus("active");
		return true;
	}

	public boolean removePatron(Patron patron) {
		if (!this.patrons.contains(patron)) return false;
		patrons.remove(patron);
		patron.setStatus("inactive");
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
		for(Patron patron:patrons) System.out.println(patron);
	}

	public void listAllTitles() {
		for(Title title:titles) System.out.println(title);
	}

	public void listAllItems() {
		for(Title title:titles) title.listAllItems();
	}

	public void listAllLoans() {
		for(Patron patron:patrons) patron.listLoans();;
	}

	public boolean isTitleObjectExists(Title title) {
		for (Title t : titles) if(t == title) return true;
		return false;
	}

	// automatically called by a successful call of the Patron "returnCheckout" method
	public boolean returnNotification(Loanable item, Patron patron) {
		Title title = item.getTitleObject();
		if (!title.isRequestExists()) return false;
		Patron requester = title.requestedTitlePrioryPatron();
		assert(requester != patron):"ABNORMAL EXPECTED CALL!!!"; // avoid any abnormal cycle
		title.removeRequest(requester);
		return requester.checkOutItem(item);
	}

	
}