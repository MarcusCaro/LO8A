import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {

	private ArrayList<Student> students = new ArrayList<>();
	private String[] files = {"Scores.txt", "badscore.txt", "nofile.txt"};
	
	void loadDataFile(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		
		while (scanner.hasNextLine()) {
			String name = scanner.nextLine();
			String line = "";
			if (!scanner.hasNextLine()) {
				break;
			}
			
		
		}
		
		scanner.close();
	}
	
	void printInOrder() {
		Collections.sort(students);
		for (Student s: students) {
			System.out.println(s);
		}
	}
	
	void processFiles() {
		loadDataFile(fileName);
		printInOrder();
	}
	
	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
	
}
