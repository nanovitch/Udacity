package ca.udacity.oopInJava.space;

public class U2 extends Rocket {
	
	U2(){
		super("U2", 18000, 29000, 120000000, 0.04, 0.08);
	}
	
	public boolean launch() {
		// The explosion probability is between 0 and 4/100
		return ( Math.random() > this.explodProb);
		 
	}

	public boolean land() {
		// The crash probability is between 0 and 8/100
		return ( Math.random() > this.crashProb);
	}

}
