package q5;

/**
 * ex 3 - Exception Handling
 * @author Itai Cohen
 * q5 - main
 */

public class Student {
	private String name;
	private int grade;

	public Student(String name, int grade) throws IllegalArgumentException {
		this.name = name;
		if (grade > 100 || grade < 0)
			throw new IllegalArgumentException("Bad grade... 0<grade<100");
		this.grade = grade;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.grade;
	}
}
