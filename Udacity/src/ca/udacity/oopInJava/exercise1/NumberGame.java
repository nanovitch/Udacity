package ca.udacity.oopInJava.exercise1;

import java.io.File;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File file = new File("t.txt");
		Scanner scanner = new Scanner(file, "UTF-8");
		int words = 0;
		int lines = 0;
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			words += line.split(" ").length;
			lines++;
		}
		System.out.println("The file contains " + lines + " lines and " + words + " words.");
		scanner.close();	
	}

}
