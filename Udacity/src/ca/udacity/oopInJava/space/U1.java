package ca.udacity.oopInJava.space;

public class U1 extends Rocket {
	
	U1(){
		super("U1", 10000, 18000, 100000000, 0.05, 0.01);
	}
	
	public boolean launch() {
		// The explosion probability is between 0 and 5/100
		return (Math.random() > this.explodProb);
	}

	public boolean land() {
		// The crash probability is between 0 and 1/100
		return (Math.random() > this.crashProb);
	}

}

