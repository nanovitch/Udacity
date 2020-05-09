package ca.udacity.oopInJava.space;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulation sim = new Simulation();
		
		ArrayList<Item> items1 = sim.loadItems("src/ca/udacity/oopinjava/space/phase-1.txt");
		ArrayList<Item> items2 = sim.loadItems("src/ca/udacity/oopinjava/space/phase-2.txt");
		
		// debug
		int total = 0;
		for(Item i:items1) total += i.getWeight();
		for(Item i:items2) total += i.getWeight();
		System.out.println("Total loaded weight: " + total);
				
		System.out.println("--------------------");
		
		
		System.out.println("U1 / PHASE 1 & 2");
		System.out.println("-----------------");
		// debug end
		ArrayList<SpaceShip> rockets11 = sim.loadU1(items1);
		ArrayList<SpaceShip> rockets12 = sim.loadU1(items2);
		
		// debug
			total = 0;
			for(SpaceShip s:rockets11) total += ((Rocket)s).fret;
			for(SpaceShip s:rockets12) total += ((Rocket)s).fret;
			System.out.println("Total carried weight: " + total + " kg using " + (rockets11.size()+rockets12.size()) + " U1 rockets");
		
			
		System.out.println("--------------------");
		// debug end
		
		double[] budgets = new double[1000000];
		for(int i=0; i<budgets.length; i++) budgets[i]=sim.runSimulation(rockets11) + sim.runSimulation(rockets12);
		double averageBudget = 0;
		for(int i=0; i<budgets.length; i++) averageBudget += budgets[i];
		averageBudget /= 1000000;
		System.out.println("Mission average cost for U1 rockets: " + averageBudget);
		
		// debug
		System.out.println("=====================================================");
		
		System.out.println("U2 / PHASE 1 & 2");
		System.out.println("-----------------");
		// debug end
		ArrayList<SpaceShip> rockets21 = sim.loadU2(items1);
		ArrayList<SpaceShip> rockets22 = sim.loadU2(items2);
		
		// debug
		total = 0;
		for(SpaceShip s:rockets21) total += ((Rocket)s).fret;
		for(SpaceShip s:rockets22) total += ((Rocket)s).fret;
		System.out.println("Total carried weight: " + total + " kg using " + (rockets21.size()+rockets22.size()) + " U2 rockets");
		
		System.out.println("--------------------");
		// debug end
		
		for(int i=0; i<budgets.length; i++) budgets[i]=sim.runSimulation(rockets21) + sim.runSimulation(rockets22);
		averageBudget = 0;
		for(int i=0; i<budgets.length; i++) averageBudget += budgets[i];
		averageBudget /= 1000000;
		System.out.println("Mission average cost for U2 rockets: " + averageBudget);
	}

}
