package ca.udacity.oopInJava.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class GuessTheMovie {
	
	private String moviesFilePath;
	private ArrayList<String> movies = new ArrayList<String>();
	
	GuessTheMovie(String moviesFilePath){
		this.moviesFilePath = moviesFilePath;
	}

	public void play() {
		File file = new File(this.moviesFilePath);
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file, "UTF-8");
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		while(scanner.hasNextLine()) movies.add(scanner.nextLine());
		scanner.close();
		
		String movieToGuess = movies.get((int) (Math.random() * movies.size()) + 1);
		String title = movieToGuess.replaceAll(".", "_"); //generating a '_' string from movieToGuess to show it on screen
		char guessedLetter;
		int wrongGuesses = 0;
		char[] chars = title.toCharArray();
		scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		do {
			System.out.println("You are guessing: " + title);
			System.out.println("You have guessed (" +  wrongGuesses + ") wrong letters:");
			System.out.println("Guess a letter:");
			guessedLetter = (char) scanner.next().charAt(0);
			for (int index = movieToGuess.indexOf(guessedLetter); index >= 0; index = movieToGuess.indexOf(guessedLetter, index + 1)) chars[index] = guessedLetter;
			if (String.valueOf(chars).equals(title)) wrongGuesses++;
			else title = String.valueOf(chars);
		} while (wrongGuesses < 10 && !movieToGuess.equals(title));
		
		scanner.close();
		System.out.println("You are guessing: " + title);
		if (!movieToGuess.equals(title))
			System.out.println("GAME OVER...YOU LOSE!" + "\n" + "The title was: " + movieToGuess);
		else
			System.out.println("GOOD JOB...YOU WIN!");
	}

}
