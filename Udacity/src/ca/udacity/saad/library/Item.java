/**
 */
package ca.udacity.saad.library;

public abstract class Item  {
	static int ITEM_UNIQUE_ID = 0;
    private final int identifier = ++ITEM_UNIQUE_ID;
	protected final String title;
	protected String status;
	
	protected Item(String title, String status) {
		this.title = title;
		this.status = status;
	}
	
	public abstract Item copy();

	public int getIdentifier() {
		return identifier;
	}

		
	public String getTitle() {
		return title;
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
		result.append(this.title);
		result.append(", status: ");
		result.append(this.status);
		result.append(')');
		return result.toString();
	}

}
