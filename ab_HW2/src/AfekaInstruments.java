
/**
*Itai cohen
*version 2
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AfekaInstruments {
	static Scanner consoleScanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
		File file = getInstrumentsFileFromUser();

		loadInstrumentsFromFile(file, allInstruments);

		if (allInstruments.size() == 0) {
			System.out.println("There are no instruments in the store currently");
			return;
		}

		printInstruments(allInstruments);

		int different = getNumOfDifferentElements(allInstruments);

		System.out.println("\n\nDifferent Instruments: " + different);

		MusicalInstrument mostExpensive = getMostExpensiveInstrument(allInstruments);

		System.out.println("\n\nMost Expensive Instrument:\n" + mostExpensive);

		startInventoryMenu(allInstruments);

		consoleScanner.close();
	}

	// **Methods**//

	public static File getInstrumentsFileFromUser() {
		boolean stopLoop = true;
		File file;

		do {
			System.out.println("Please enter instruments file name / path:");
			String filepath = consoleScanner.nextLine();
			// **/
			filepath = "/home/itai/eclipse-workspace/yasb HW2/instruments1b.txt";
			// ***/
			file = new File(filepath);
			stopLoop = file.exists() && file.canRead();

			if (!stopLoop)
				System.out.println("\nFile Error! Please try again\n\n");
		} while (!stopLoop);
		return file;
	}

	public static void loadInstrumentsFromFile(File file, ArrayList<MusicalInstrument> allInstruments) {
		Scanner scanner = null;

		try {

			scanner = new Scanner(file);

			addAllInstruments(allInstruments, loadGuitars(scanner));

			addAllInstruments(allInstruments, loadBassGuitars(scanner));

			addAllInstruments(allInstruments, loadFlutes(scanner));

			addAllInstruments(allInstruments, loadSaxophones(scanner));

		} catch (InputMismatchException | IllegalArgumentException ex) {
			System.err.println("\n" + ex.getMessage());
			System.exit(1);
		} catch (FileNotFoundException ex) {
			System.err.println("\nFile Error! File was not found");
			System.exit(2);
		} finally {
			scanner.close();
		}
		System.out.println("\nInstruments loaded from file successfully!\n");
	}

	public static ArrayList<Guitar> loadGuitars(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList<Guitar> guitars = new ArrayList<Guitar>(numOfInstruments);

		for (int i = 0; i < numOfInstruments; i++)
			guitars.add(new Guitar(scanner));

		return guitars;
	}

	public static ArrayList<Bass> loadBassGuitars(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList<Bass> bassGuitars = new ArrayList<Bass>(numOfInstruments);

		for (int i = 0; i < numOfInstruments; i++)
			bassGuitars.add(new Bass(scanner));

		return bassGuitars;
	}

	public static ArrayList<Flute> loadFlutes(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList<Flute> flutes = new ArrayList<Flute>(numOfInstruments);

		for (int i = 0; i < numOfInstruments; i++)
			flutes.add(new Flute(scanner));

		return flutes;
	}

	public static ArrayList<Saxophone> loadSaxophones(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList<Saxophone> saxophones = new ArrayList<Saxophone>(numOfInstruments);

		for (int i = 0; i < numOfInstruments; i++)
			saxophones.add(new Saxophone(scanner));

		return saxophones;
	}

	public static <E extends MusicalInstrument> void addAllInstruments(ArrayList<MusicalInstrument> instruments,
			ArrayList<E> moreInstruments) {
		for (int i = 0; i < moreInstruments.size(); i++) {
			instruments.add(moreInstruments.get(i));
		}
	}

	public static void printInstruments(ArrayList<MusicalInstrument> instruments) {
		for (int i = 0; i < instruments.size(); i++)
			System.out.println(instruments.get(i));
	}

	public static int getNumOfDifferentElements(ArrayList<MusicalInstrument> instruments) {
		int numOfDifferentInstruments;
		ArrayList<MusicalInstrument> differentInstruments = new ArrayList<MusicalInstrument>();
		System.out.println();

		for (int i = 0; i < instruments.size(); i++) {
			if (!differentInstruments.contains((instruments.get(i)))) {
				differentInstruments.add(instruments.get(i));
			}
		}

		if (differentInstruments.size() == 1)
			numOfDifferentInstruments = 0;

		else
			numOfDifferentInstruments = differentInstruments.size();

		return numOfDifferentInstruments;
	}

	public static MusicalInstrument getMostExpensiveInstrument(ArrayList<MusicalInstrument> instruments) {
		double maxPrice = 0;
		MusicalInstrument mostExpensive = (MusicalInstrument) instruments.get(0);

		for (int i = 0; i < instruments.size(); i++) {
			MusicalInstrument temp = (MusicalInstrument) instruments.get(i);

			if (temp.getPrice().doubleValue() > maxPrice) {
				maxPrice = temp.getPrice().doubleValue();
				mostExpensive = temp;
			}
		}
		return mostExpensive;
	}

	public static void startInventoryMenu(ArrayList<MusicalInstrument> allInstrumentsFromFile) {
		ArrayList<MusicalInstrument> list = new ArrayList<MusicalInstrument>();
		AfekaInventory<MusicalInstrument> aInv = new AfekaInventory<MusicalInstrument>(list);

		String brand = null;
		Double price;

		boolean isExitMenuPressed = false;
		while (!isExitMenuPressed) {

			System.out.println("-------------------------------------------------------------------------"
					+ "\nAFEKA MUSICAL INSTRUMENT INVENTORY MENU"
					+ "\n-------------------------------------------------------------------------"
					+ "\n1. Copy All String Instruments To Inventory" + "\n2. Copy All Wind Instruments To Inventory"
					+ "\n3. Sort Instruments By Brand And Price" + "\n4. Search Instrument By Brand And Price"
					+ "\n5. Delete Instrument" + "\n6. Delete all Instruments" + "\n7. Print Inventory Instruments"
					+ "\nChoose your option or any other key to EXIT\n");

			int select = consoleScanner.nextInt();

			System.out.println("Your Option: " + select + "\n");
			switch (select) {

			case 1: // 1. Copy All String Instruments To Inventory
				aInv.addAllStringInstruments(allInstrumentsFromFile, aInv.getList());
				break;

			case 2:// 2. Copy All Wind Instruments To Inventory
				aInv.addAllWindInstruments(allInstrumentsFromFile, aInv.getList());
				break;

			case 3:// 3. Sort Instruments By Brand And Price
				aInv.SortByBrandAndPrice(aInv.getList());
				break;

			case 4:// 4. Search Instrument By Brand And Price
				System.out.println("SEARCH INSTRUMENT:");
				brand = brandReader(consoleScanner);
				price = priceReader(consoleScanner);
				int binSearcRes = aInv.binnarySearchByBrandAndPrice(aInv.getList(), brand, price);
				aInv.isItemExist(aInv.getList(), binSearcRes);
				break;

			case 5:// 5. Delete Instrument
				System.out.println("DELETE INSTRUMENT:");
				brand = brandReader(consoleScanner);
				price = priceReader(consoleScanner);
				aInv.removeInstrument(aInv.getList(), brand, price);
				break;

			case 6:// 6. Delete all Instruments
				aInv.removeAll(aInv.getList());
				break;

			case 7:// 7. Print Inventory Instruments
				PrintArrayOfMusicalInstrument(aInv);
				break;

			default:// exit
				isExitMenuPressed = true;
				System.out.println("Finished!");
				break;
			}
		}
	}

	public static String brandReader(Scanner innerScanner) {
		System.out.print("Brand:");
		return innerScanner.next();
	}

	public static Double priceReader(Scanner innerScanner) {
		boolean isNotValidInput = true;
		Double price = null;
		while (isNotValidInput) {
			System.out.print("Price:");
			try {
				price = innerScanner.nextDouble();
				isNotValidInput = false;
			} catch (NumberFormatException ex) {
				System.out.println("price must be a valid number");
				innerScanner.next();
			} catch (InputMismatchException ex) {
				System.out.println("price must be a valid number");
				innerScanner.next();
			}
		}
		return price;
	}

	public static void PrintArrayOfMusicalInstrument(AfekaInventory<MusicalInstrument> inventory) {
		System.out.println("-------------------------------------------------------------------------"
				+ "\nAFEKA MUSICAL INSTRUMENTS INVENTORY"
				+ "\n-------------------------------------------------------------------------");
		if (inventory.getList() == null || inventory.getList().isEmpty())
			System.out.println("There Is No Instruments To Show");
		else
			printInstruments(inventory.getList());
		System.out.println("\n" + inventory + "\n");
	}

}
