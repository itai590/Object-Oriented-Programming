package q1q2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = null;
		int grade = 0;
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while (flag)
			try {
				System.out.println("enter name");
				name = input.next();
				System.out.println("enter grade");
				grade = input.nextInt();
				flag = false;
				Student avi = new Student(name, grade);
			} catch (InputMismatchException e) {
				System.out.println(e.getStackTrace());
				System.err.println("wrong input");
				input.nextLine();
			}
		System.out.println("name:" + name);
		System.out.println("grade:" + grade);
	}
}
