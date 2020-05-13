/**
 */
package ca.udacity.saad.library;

public abstract class Item  {
	private static int ITEM_UNIQUE_ID = 0;
    private final int identifier = ++ITEM_UNIQUE_ID;
	protected final Title title;
	protected String status;
		
	public Item(Title title, String status) {
		assert(title != null);
		this.title = title;
		this.title.incNumCopies();
		this.status = status;
	}
	
	protected abstract Item copy();
	
	public int getNumCopies() {
		return this.title.getNumCopies();
	}
	
	public void incNumCopies() {
		this.title.incNumCopies();
	}
	
	public void decNumCopies() {
		this.title.decNumCopies();;
	}

	public int getIdentifier() {
		return identifier;
	}

		
	public String getTitle() {
		return title.getTitle();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		
	}
	
	public abstract boolean isCheckable();

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (identifier: ");
		result.append(this.identifier);
		result.append(", title: ");
		result.append(this.title.getTitle());
		result.append(", status: ");
		result.append(this.status);
		result.append(')');
		return result.toString();
	}

}
