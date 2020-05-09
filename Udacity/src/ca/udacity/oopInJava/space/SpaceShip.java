package ca.udacity.oopInJava.space;

public interface SpaceShip {
	boolean launch();
	boolean land();
	boolean canCarry(Item item);
	void carry(Item item);

}