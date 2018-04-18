package q5;
/**
 * ex 3 - Exception Handling
 * @author Itai Cohen
 * q5 - main
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		String filename;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the file's path & name:");
		filename = input.nextLine();
		filename = "/home/itai/txt";
		PrintWriter output = null;
		boolean isNumStudentOk = false;
		boolean ifFileOk = true;
		while (!(isNumStudentOk)) {
			try {
				output = new PrintWriter(filename);
				if (output.checkError())
					throw new FileNotFoundException("(The system cannot find the path specified)");
				System.out.println("Please enter the number of students:");
				int n = input.nextInt();
				isNumStudentOk = true;
				stduentsToFile(n, output);
			} catch (FileNotFoundException e) {
				ifFileOk = false;
				System.out.println(e.getMessage());
				isNumStudentOk = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input... an integer value is needed...");
				input.nextLine();
			} finally {
				if (ifFileOk)
					output.close();
			}
		}
		System.out.println("Program ends now...");
	}

	public static void stduentsToFile(int n, PrintWriter output) {

		Student[] studentArr = new Student[n];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			while (flag) {
				try {
					System.out.println("Please enter name for student #" + (i + 1) + ":");
					String name = input.nextLine();
					System.out.println("Please enter grade for student #" + (i + 1) + ":");
					int grade = input.nextInt();
					input.nextLine();

					studentArr[i] = new Student(name, grade);
					flag = false;
				} catch (IllegalArgumentException ex) {
					System.out.println(ex.getMessage());
				} catch (InputMismatchException ex) {
					System.out.println("Bad grade... Integer is needed...");
					input.nextLine();
				}
			}
			output.println(studentArr[i]);
		}
	}
}
