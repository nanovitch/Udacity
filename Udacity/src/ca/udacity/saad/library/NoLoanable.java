package ca.udacity.saad.library;

public abstract class NoLoanable extends Item {
	
	public NoLoanable(Title title) {
		super(title, "not checkable");
	}
	
	@Override
	public boolean isCheckable() {
		return false;
	}	
	
	protected abstract Item copy();
}
