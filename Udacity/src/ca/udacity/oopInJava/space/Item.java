package ca.udacity.oopInJava.space;

public class Item {//implements Comparable<Item>{ // si on veut pouvoir trier une liste Item. Voir une facon plus rapide de le faire a la fin de la fct "loadItems" de "Simulation.java"
	private String name;
	private int weight;
	
	/*@Override
	public int compareTo(Item otherItem) {
		return this.weight < otherItem.weight;
	}*/
	
	Item(String name, int weight){
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return this.weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	

}
