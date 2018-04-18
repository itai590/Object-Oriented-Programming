package q3q4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cmain {
	final static int MAX = 15;
	final static int MIN = 5;

	public static int range(int num) throws IllegalArgumentException {
		int sum = 0;
		try {
			if (!(num >= MIN && num <= MAX))
				throw new IllegalArgumentException("invalid input");

			for (int i = MIN; i <= num; i++)
				sum += i;

		} catch (IllegalArgumentException ex) {
			System.out.println("The input is out of range...");
		}
		return sum;
	}

	public static void main(String[] args) throws IllegalArgumentException, InputMismatchException {
		// TODO Auto-generated method stub
		boolean flag = true;
		int num = 0;
		Scanner input = new Scanner(System.in);
		while (flag) {
			try {
				System.out.println("Please enter an integer value, in the range of " + MIN + " to " + MAX + ":");
				num = input.nextInt();
				if (range(num) == 0)
					throw new IllegalArgumentException("err");
				System.out.println("ans=" + range(num));
				flag = false;
			} catch (IllegalArgumentException ex) {
				input.nextLine();
			} catch (InputMismatchException ex) {
				System.out.println("The input is not an integer...");
				input.nextLine();
			}
		}
	}
}
