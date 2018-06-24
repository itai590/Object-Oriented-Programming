import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Itai Cohen
 */
public class AfekaInstruments {
	final static int numOfDiffrentInstrumentsInFile = 4;

	public static ArrayList addAllInstruments(ArrayList sourceList, ArrayList targetList) {
		for (int i = 0; i < sourceList.size(); i++) {
			targetList.add(sourceList.get(i));
		}
		return targetList;
	}

	public static void printInstruments(ArrayList<Instrument> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static Instrument getMostExpensiveInstrument(ArrayList<Instrument> list) {
		double maxPrice = list.get(0).getPrice();
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPrice() > maxPrice) {
				maxPrice = list.get(i).getPrice();
				index = i;
			}
		}
		return list.get(index);
	}

	public static int getNumOfDifferentElement(ArrayList<Instrument> list) {
		int NumOfDifferentElement = 0;
		for (int i = 0; i < list.size(); i++) {
			boolean isDiffrent = true;
			for (int j = 0; j < i; j++) {
				if (list.get(j).equals(list.get(i))) {
					isDiffrent = false;
					break;
				}
			}
			if (isDiffrent)
				NumOfDifferentElement++;
		}
		return NumOfDifferentElement;
	}

	public static void main(String[] args) throws Exception {

		Scanner consolScanner = new Scanner(System.in);
		Scanner fileScanner = null;
		boolean isFileOk = false;
		File file = null;
		while (!isFileOk) {
			System.out.println("Please enter instruments file name / path:");
			String filename = consolScanner.nextLine();
//			// **for my tests only!!**
			 filename = "instruments" + filename + ".txt";
//			 String testFilename = "/home/itai/instruments" + filename + ".txt";
//			 filename = testFilename;
			file = new File(filename);
			try {
				fileScanner = new Scanner(file);
				isFileOk = true;
			} catch (FileNotFoundException e) {
				System.out.println("File Error! Please try again:");
			}
		}
		ArrayList allInstrumentsList = new ArrayList();
		ArrayList guitarsList = new ArrayList();
		ArrayList bassGuitarList = new ArrayList();
		ArrayList fluteList = new ArrayList();
		ArrayList saxophoneList = new ArrayList();

		int instrumentsAmounts[] = new int[4]; // amount array with all amounts of all instruments by types (Guitar,
		// BassGuitar, Flute, Saxophone)
		boolean isStoreEmpty = true;
		for (int i = 0; i < numOfDiffrentInstrumentsInFile; i++) {
			instrumentsAmounts[i] = fileScanner.nextInt();
			if (instrumentsAmounts[i] != 0)
				isStoreEmpty = false;

			for (int j = 0; j < instrumentsAmounts[i]; j++) {
				try {
					switch (i) {
					case (0):
						guitarsList.add(new Guitar(fileScanner));
						break;
					case (1):
						bassGuitarList.add(new BassGuitar(fileScanner));
						break;
					case (2):
						fluteList.add(new Flute(fileScanner));
						break;
					case (3):
						saxophoneList.add(new Saxophone(fileScanner));
						break;
					}
				} catch (NumberFormatException ex) {
					System.err.println("Error - Number Expected");
					System.err.println(ex.getMessage());
				} catch (NullPointerException ex) {
					System.err.println(ex.getMessage());
				} catch (InputMismatchException ex) {
					System.err.println(ex.getMessage());
				}
			}
		}
		fileScanner.close();
		addAllInstruments(guitarsList, allInstrumentsList);
		addAllInstruments(bassGuitarList, allInstrumentsList);
		addAllInstruments(fluteList, allInstrumentsList);
		addAllInstruments(saxophoneList, allInstrumentsList);

		System.out.println("Instruments loaded from file successfully!");
		if (isStoreEmpty)
			System.out.println("There are no instruments in the store currently");
		else {
			printInstruments(allInstrumentsList);
			System.out.println("\nDifferent Instruments: " + getNumOfDifferentElement(allInstrumentsList) + "\n");
			System.out.println("Most Expensive Instrument:\n" + getMostExpensiveInstrument(allInstrumentsList));
		}
	}
}
