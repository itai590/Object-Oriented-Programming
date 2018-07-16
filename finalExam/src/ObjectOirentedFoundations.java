import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ObjectOirentedFoundations {
	private static File in;
	private static File out;
	private static Scanner reader;
	private static PrintWriter print;
	private static final int numberOfCicles = 3;

	public static void main(String[] args) throws FileNotFoundException {
		in = new File("i3.txt");
		out = new File("o3.txt");
		reader = new Scanner(in);
		print = new PrintWriter(out);
		Integer[] integers = { 1, 2, 3, 4, 4, 6, -5, 601, 0, 700, 800, 800 };
		Double[] doubles = { 1.0, 2.1, 3.2, 4.1, 4.4, -6.06 };
		Circle[] circles = new Circle[numberOfCicles];
		for (int i = 0; i < numberOfCicles; i++) {
			try {
				double radius = reader.nextDouble();
				circles[i] = new Circle(radius);
			} catch (InputMismatchException ex) {
				//System.err.println("error");
				//System.err.println(ex.getMessage());
				circles[i] = new Circle(1 + Math.random() * 3, "Yellow");
			}
		}
		selectionSort(integers);
		printResult(integers, "sorted integers array");
		selectionSort(doubles);
		printResult(doubles, "\nsorted doubles array");
		selectionSort(circles);
		printResult(circles, "\nsorted circles array");
		reader.close();
		print.close();

	}

	public static <E> void printResult(E[] arr, String str) {
		print.println(str);
		for (int i = 0; i < arr.length; i++) {
			print.print(" " + arr[i]);
		}
	}

	public static <E extends Comparable<E>> 
	  void selectionSort(E[] list) {
		for (int i = 0; i < list.length - 1; i++) { // Find the minimum in the
													// // list[i..list.length-1]
			E currentMin = list[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin.compareTo(list[j]) > 0) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
}
