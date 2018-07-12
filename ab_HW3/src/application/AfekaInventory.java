package application;

/**
 * @author Itai Cohen
 * @version 3 - SearchByKey added
*/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AfekaInventory<E extends MusicalInstrument> implements InventoryManagement<E> {
	private ArrayList<E> list;
	private double totalPrice;
	private boolean isSorted;
	private Scanner scanner;

	// Constructors
	public AfekaInventory(ArrayList<E> list) {
		this.list = list;
		this.totalPrice = 0;
		this.isSorted = false;
	}

	public AfekaInventory() {
		ArrayList<E> list = null;
		this.list = list;
		this.totalPrice = 0;
		this.isSorted = false;
	}

	// **Getters and Settters**//
	public ArrayList<E> getList() {
		return list;
	}

	public void setList(ArrayList<E> list) {
		this.list = list;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isSorted() {
		return isSorted;
	}

	public void setSorted(boolean isSorted) {
		this.isSorted = isSorted;
	}

	// **Special Functions**//
	public Double addNumbers(Number n1, Number n2) {
		return n1.doubleValue() + n2.doubleValue();
	}

	public Double subNumbers(Number n1, Number n2) {
		return n1.doubleValue() - n2.doubleValue();
	}

	@Override
	public void addAllStringInstruments(ArrayList<? extends MusicalInstrument> src,
			ArrayList<? super MusicalInstrument> to) {
		for (int i = 0; i < src.size(); i++) {
			if (src.get(i) instanceof StringInstrument) {
				to.add(src.get(i));
				double n = addNumbers(getTotalPrice(), ((StringInstrument) src.get(i)).getPrice());
				setTotalPrice(n);
			}
		}
		setSorted(false);
		System.out.println("All String Instruments Added Successfully!\n");
	}

	@Override
	public void addAllWindInstruments(ArrayList<? extends MusicalInstrument> src,
			ArrayList<? super MusicalInstrument> to) {
		for (int i = 0; i < src.size(); i++) {
			if (src.get(i) instanceof WindInstrument) {
				to.add(src.get(i));
				setTotalPrice(addNumbers(getTotalPrice(), ((WindInstrument) src.get(i)).getPrice()));
			}
		}
		setSorted(false);
		System.out.println("All Wind Instruments Added Successfully!\n");
	}

	@Override
	public void SortByBrandAndPrice(ArrayList<E> list) {
		// Collections.sort(list);
		E temp;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 1; j < (list.size() - i); j++) {
				if (((MusicalInstrument) list.get(j - 1)).compareTo((MusicalInstrument) list.get(j)) > 0) {
					temp = list.get(j - 1);
					list.set(j - 1, list.get(j));
					list.set(j, temp);
				}
			}
		}
		setSorted(true);
		System.out.println("Instruments Sorted Successfully!\n");
	}

	// @Override
	public int binnarySearchByBrandAndPrice(ArrayList<E> src, String brand, Number price) {
		if (!isSorted)
			SortByBrandAndPrice(src);
		int lo = 0;
		int hi = list.size() - 1;
		while (hi >= lo) {
			int mid = (lo + hi) / 2;
			if (price.doubleValue() == ((MusicalInstrument) (src.get(mid))).getPrice().doubleValue()) {
				if (brand.toLowerCase().compareTo(((MusicalInstrument) src.get(mid)).getBrand().toLowerCase()) > 0)
					hi = mid - 1;
				else if (brand.equalsIgnoreCase((((MusicalInstrument) src.get(mid)).getBrand())))
					return mid;
				else
					lo = mid + 1;
			} else
				lo++;
		}
		return -1;
	}

	public ArrayList<E> SearchByKey(ArrayList<E> src, String key) {
		ArrayList<E> ans = new ArrayList<E>();
		int j = 0;
		for (int i = 0; i < src.size(); i++) {
			if (src.get(i).toString().toLowerCase().contains(key)) {
				ans.add(j, src.get(i));
				j++;
			}
		}
		return ans;
	}

	@Override
	public void addInstrument(ArrayList<E> src, E m) {
		if (src.getClass().equals(m.getClass())) {
			src.add(m);
			setSorted(false);
		}
	}

	public boolean isItemExist(ArrayList<E> list, int searchRes) {
		if (searchRes > 0) {
			System.out.println("Result:");
			PrintMusicalInstrument(list, searchRes);
			return true;

		} else {
			System.out.println("Instrument Not Found!");
			return false;
		}
	}

	@Override
	public boolean removeInstrument(ArrayList<E> src, String brand, Number price) {

		int binnarySearcRes = binnarySearchByBrandAndPrice(src, brand, price);
		if (isItemExist(src, binnarySearcRes)) {

			boolean isNotValidInput = true;
			while (isNotValidInput) {
				System.out.println("Are You Sure?(Y/N)");
				scanner = new Scanner(System.in);
				try {
					String ans = scanner.next();
					if (ans.length() > 1)
						throw new InputMismatchException("[Y] or [N] only");
					if (ans.equalsIgnoreCase("y")) {
						src.remove(binnarySearcRes);
						System.out.println("Instrument Deleted Successfully!");
					} else
						System.out.println("Instrument Was Not Deleted!");
					isNotValidInput = false;
				} catch (InputMismatchException ex) {
					System.err.println(ex.getMessage() + "\n");
				}
			}
			setTotalPrice(subNumbers(getTotalPrice(), price));
			return true;
		}
		return false;
	}

	@Override
	public String removeAll(ArrayList<E> src) {
		if (src.removeAll(src)) {

			setTotalPrice(0);
			setSorted(false);
			return "All Instruments Deleted Successfully!";
		}
		return "The operation Remove all failed";
	}

	@Override
	public String toString() {
		return String.format("Total Price: %-10.2f Sorted: %5s ", this.getTotalPrice(), this.isSorted);
	}

	public void PrintMusicalInstrument(ArrayList<E> list, int index) {
		System.out.println(list.get(index));
	}
}
