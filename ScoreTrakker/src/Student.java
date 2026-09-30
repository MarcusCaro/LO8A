/*
 * 
 */

public class Student implements Comparable<Student> {
	
	private String _name;
	private int _score;
	
	
	public Student(String name, int score) {
		_name = name;
		_score = score;
	}

	@Override
	public String toString() {
		return _name + " " + _score;
	}


	@Override
	public int compareTo(Student o) {
		return _name.compareTo(o._name);
	}
	
}
