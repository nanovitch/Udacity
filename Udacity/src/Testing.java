

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		/*
		// tri ascendant
		List<Integer> integers = new ArrayList<Integer>() {
			{add(3);add(5);add(4);add(1);add(7);add(9);add(3);add(5);add(8);}
		};
		
		int[] v1 = {1,3,5,4,1,7,9,3,5,8};
		int[] v2 = new int[v1.length];
		
		for (int i=0; i<v1.length; i++) {
			int min = 0;
			for (int j=0; j<v1.length; j++) if (v1[j] < v1[min]) min=j;
			System.out.print(min + " ");
			System.out.println();
			v2[i] = v1[min];
			v1[min] = Integer.MAX_VALUE;
		}
		for (int i=0; i<v2.length; i++) System.out.print(v2[i] + " ");
		*/
		
		/*
		Scanner sc = new Scanner(System.in);
		String str;
		int mode;
		double val, conv, arrondi;
		do {
			System.out.println("Choisissez le mode de conversion : ");
			System.out.println("1 - Convertisseur Celsius - Farenheit");
			System.out.println("2 - Convertisseur Farenheit - Celsius");
			mode = sc.nextInt(); 
			if (mode != 1 && mode != 2) {
				System.out.println("Mode inconnu. Veuillez reitirer votre choix. ");
				str = "O"; // la condition de boucle est testee meme avec "continue"!!!!
				continue;
			}
			System.out.println("Temperature a convertir: ");
		    val = sc.nextDouble(); 
		    if (mode == 1) {
		    	conv = 9*val/5+32;
		    	arrondi = Testing.arrondi(conv, 2);
		    	System.out.println(val + " C correspond a : " + arrondi + " F.");
		    }
		    else {
		    	conv = (val-32)*5/9;
		    	arrondi = Testing.arrondi(conv, 2);
		    	System.out.println(val + " F correspond a : " + arrondi + " C.");
		    }
		    System.out.println("Voulez-vous faire une nouvelle conversion (O/N): ");
		    sc.nextLine();
		    str = sc.nextLine();
		} while(str.charAt(0) == 'O');
	    
		System.out.println("Au revoir !");
	    sc.close();
	    */
		/*
	    String[][] tabStr2 = {{"1", "2", "3", "4"}, {"toto", "titi", "tata"}};
	    parcourirTableau(tabStr2);
	    
	    String tab[][] = {{"toto", "titi", "tutu"}, {"tata", "tete", "tyty"}};
	    
	    for(String str[] : tab)
	    {
	     	for(String str2 : str)
	     	{
	         	System.out.println("La valeur est  = " + str2);
	     	}
	     
	    }*/
		
		
	}
	
	public static double arrondi(double A, int B) {
		  return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
	}
	
	static void parcourirTableau(String[][] tab)
	{
	  for(String[] tab2 : tab)
	  {
	    for(String str : tab2)
	      System.out.println(str);
	  }
	}
	
}

class Vehicle{
	Vehicle(){
		System.out.println("Vehicle");
	}
	
}

class Car extends Vehicle{
	Car(){
		System.out.println("Car");
	}
	
}
