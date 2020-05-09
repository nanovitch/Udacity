package ca.udacity.oopInJava.space;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;

public class Simulation {
		
	ArrayList<Item> loadItems(String fileName){
		ArrayList<Item> items = new ArrayList<Item>();
		File file = new File(fileName);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file, "UTF-8");
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		while(scanner.hasNextLine()) {
			String[] s= scanner.nextLine().split("=");
			items.add(new Item(s[0], Integer.parseUnsignedInt(s[1])));
		}
		//Collections.sort(items);
		scanner.close();
		
		//Collections.sort(items, (d1, d2) -> {return d1.getWeight() - d2.getWeight();}); //trier la liste par ordre croissant de weight
		//for(Item i:items) System.out.println(i.getName() + "=" + i.getWeight());
		
		return items;
	}
	
	ArrayList<SpaceShip> loadU1(ArrayList<Item> items){
		return loadRocket(items, "U1");
	}
	
	ArrayList<SpaceShip> loadU2(ArrayList<Item> items){
		return loadRocket(items, "U2");
	}
	
	double runSimulation(ArrayList<SpaceShip> rockets) {
		double budget = 0;
		for(SpaceShip rocket:rockets) {
			while (!((Rocket)rocket).launch() || !((Rocket)rocket).land()) budget += ((Rocket)rocket).cost;
			budget += ((Rocket)rocket).cost;
		}
		return budget;
	}
	
	private ArrayList<SpaceShip> loadRocket(ArrayList<Item> items, String model){
		ArrayList<SpaceShip> s = new ArrayList<SpaceShip>();
		Rocket u;
		if (model == "U1") u = new U1();
		else u = new U2();
		Item item;
		for(int i=0; i<items.size();i++) {
			item = items.get(i);
			if (u.canCarry(item)) u.carry(item);
			else {
				s.add(u);
				if (model == "U1") u = new U1();
				else u = new U2();
				u.carry(item);	
			}
		}
		s.add(u);
		return s;
	}
	

}
