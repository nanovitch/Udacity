/**
 */
package ca.udacity.oopInJava.library.newVersion;

public  class Item  {
	private static int ITEM_UNIQUE_ID = 0;
	
    private final int identifier = ++ITEM_UNIQUE_ID;
    private final Title title;
	protected String status;
	
			
	public Item(Title title, String status) {
		assert(title != null):"an item must have a title!";
		this.title = title;
		this.status = status;
		
	}
	
	public int getIdentifier() {
		return identifier;
	}

	public String getTitle() {
		return title.getTitle();
	}
	
	

	public Title getTitleObject() {
		return this.title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		
	}
	
	//public abstract boolean isCheckable();

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
