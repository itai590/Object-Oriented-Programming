import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Itai Cohen
 */
public class Instrument {
	private double price;
	private String companyName;

	public Instrument(Scanner fileReader) {
		try {
			setPrice(fileReader.nextDouble());
		} catch (NumberFormatException ex) {
			System.err.println(ex.getMessage());
		}
		this.companyName = fileReader.next();
	}

	public Instrument(double price, String companyName) {
		{
			setPrice(price);
			setCompanyName(companyName);
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		try {
			if (price < 0)
				throw new InputMismatchException("Price must be a positive number!");
			else
				this.price = price;
		} catch (InputMismatchException ex) {
			System.err.println(ex.getMessage());
			System.exit(0);
		}
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-13s| %s %7.2f,", companyName, super.getClass().getCanonicalName(), "Price: ",
				price);
	}

	public boolean stringEqual(String str1, String str2) {
		if (str1.length() == str2.length()) {
			for (int i = 0; i < str1.length(); i++) {
				if (!(str1.charAt(i) == str1.charAt(i)))
					return false;
			}
			return true;
		}
		return false;
	}

	public boolean equals(Object o) {
		if (o instanceof Instrument) {
			Instrument i = (Instrument) o;
			return (i.getPrice() == this.getPrice() && stringEqual(i.getCompanyName(), this.getCompanyName()));
		}
		return false;
	}
}
