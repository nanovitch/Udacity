package ca.udacity.saad.library;

public abstract class NoCheckable extends Item {
	
	protected NoCheckable(String title) {
		super(title, "not checkable");
	}
	
	@Override
	public boolean isCheckable() {
		return false;
	}	
	
	public abstract Item copy();
}
