package ca.udacity.oopInJava.exercise1;

import java.util.Scanner;
import java.io.File;

public class GuessTheNumber {

	public static void main(String[] args) {
		
		int guesses = 10;
		int number = (int) (Math.random() * 100) + 1;
		int guessed;
		boolean success = false;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("I have randomly chosen a random number between 1-100");
		do {
			System.out.println("Try to guess it." + "\n" + "You have " + guesses-- + " left:");
			
			guessed = scanner.nextInt();
			if (guessed == number) {
				success = true;
				System.out.println("CORRECT...YOU WIN!");
			}
			else {
				if (guessed < number) System.out.println("It is greater than " + guessed);
				else System.out.println("It is smaller than " + guessed);
			}
				
		} while (guesses > 0 && !success);
		if (!success)
			System.out.println("GAME OVER...YOU LOSE!" + "\n" + "The number was: " + number);
		scanner.close();
		

	}

}
