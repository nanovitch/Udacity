package ca.udacity.oopInJava.exercise1;

import java.util.Scanner;
import java.io.File;

public class FileWordsCount {

	public static void main(String[] args) throws Exception{
		
		File file = new File("src/ca/udacity/oopinjava/exercise1/A Tale of Two Cities.txt");
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
