/*
 * Class: ScoreTrakker - Reads in files containing students names and scores,
 * handling incorrect score formatting and file not found errors.
 * 
 * Authors: Marcus Caro, Trisha Varadaraj 
 * Date: 9/30/2026
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {

	private ArrayList<Student> students = new ArrayList<>(); // Stores list of students records 
	private String[] files = {"Scores.txt", "badscores.txt", "nofile.txt"};
	
	void loadDataFile(String fileName) throws FileNotFoundException {
		students.clear();
		Scanner scanner = new Scanner(new File(fileName)); 
		
		while (scanner.hasNextLine()) {
			String name = scanner.nextLine();
			String line = "";
			if (!scanner.hasNextLine()) { // Guard here against the Odd Lines that are Missing the Score . 
				break;
			}
			
			try {
				line = scanner.nextLine();
				int score = Integer.parseInt(line.trim());
				students.add(new Student(name, score));
			} catch (NumberFormatException e) {
				System.out.println("Incorrect format for " + name + "not a valid score: " + line); // Log non - numeric score errors and skip basd student  On record . 
				System.out.println();
			}
		
		}
		
		scanner.close();
	}
	// Sorts the Student list in the natural order and prints the record of each to standard outputs with Iteration . 
	void printInOrder() { 
		Collections.sort(students);
		System.out.println("Student Score List");
		for (Student s: students) { // Loop to iterate through sorted students . 
			System.out.println(s);
		}
		System.out.println();
	}
	
	void processFiles() {
		for (String file : files) {
			try {
				loadDataFile(file);
				printInOrder();
			} catch (FileNotFoundException e) {
				System.out.println("Can't open file: " + file); // Stops crashing of Program 
			}
			
		}
		
	}
	
	public static void main(String[] args) { // Makes ScoreTrakker instance and runs processFiles. 
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
	
}
