/*
 * Class: Student - Represents an individual student 
 * with a name and numerical test score. Also has comparing elements 
 * to let students be sorted by alphabetical order by name. 
 * 
 * Authors: Marcus Caro, Trisha Varadaraj
 * Date: 9/30/2026
 */

public class Student implements Comparable<Student> {
	
	private String _name; 
	private int _score;
	
	
	public Student(String name, int score) { 
		_name = name;
		_score = score;
	}

	@Override 
	public String toString() { // Returns string representation of student by " Name, Score" format . 
		return _name + " " + _score;
	}


	@Override
	public int compareTo(Student o) { // Compares student to other student based on names . 
		return _name.compareTo(o._name);
	}
	
}
