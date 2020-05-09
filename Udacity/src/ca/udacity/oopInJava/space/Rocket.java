package ca.udacity.oopInJava.space;

public class Rocket implements SpaceShip {
	
	final String model;
	double weight;
	final double maxWeight;
	final int cost;
	double explodProb, crashProb;
	int fret = 0;
	
	Rocket(String model, int weight, int maxWeight, int cost, double explodProbBase, double crashProbBase){
		this.model = model;
		this.weight = weight;
		this.maxWeight = maxWeight;
		this.cost = cost;
		this.explodProb = explodProbBase * this.weight/this.maxWeight;
		this.crashProb = crashProbBase * this.weight/this.maxWeight;
	}
	
	@Override
	public boolean launch(){
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean land(){
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public final boolean canCarry(Item item) {
		// TODO Auto-generated method stub
		return this.weight + item.getWeight() <= this.maxWeight;
	}

	@Override
	public final void carry(Item item) {
		// TODO Auto-generated method stub
		this.fret += item.getWeight();
		this.weight += this.fret;
	}

}
