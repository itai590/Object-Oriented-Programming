package application;
/**
 * Itai Cohen
 * @version 1
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MusicalInstrument implements InstrumentFunc {
	private Number price;
	private String brand;

	public MusicalInstrument(String brand, Number price) {
		setBrand(brand);
		setPrice(price);
	}

	public MusicalInstrument(Scanner scanner) {
		String priceStr;
		String brand;
		priceStr = scanner.next();
		setPrice(priceStr);
		scanner.nextLine();
		brand = scanner.nextLine();
		setBrand(brand);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Number getPrice() {
		return price;
	}

	private void setPrice(String price) {
		try {
			if (price.contains("."))
				setPrice(Double.valueOf(price));
			else
				setPrice(Integer.valueOf(price));
		} catch (NumberFormatException ex) {
			throw new InputMismatchException("Price not found!");
		}
	}

	public void setPrice(Number price) {
		if (price.doubleValue() > 0) {
			if (price instanceof Integer)
				this.price = (Integer) price;
			else if (price instanceof Double)
				this.price = (Double) price;
		} else
			throw new InputMismatchException("Price must be a positive number!");
	}

	protected boolean isValidType(String[] typeArr, String material) {
		if (!(material == null)) {
			for (int i = 0; i < typeArr.length; i++) {
				if (material.equals(typeArr[i])) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof MusicalInstrument))
			return false;

		MusicalInstrument otherInstrument = (MusicalInstrument) o;

		return getPrice().doubleValue() == otherInstrument.getPrice().doubleValue()
				&& getBrand().equalsIgnoreCase(otherInstrument.getBrand());
	}

	@Override
	public String toString() {
		return String.format("%-8s %-9s| Price: %7s,", getBrand(), getClass().getSimpleName(), getPrice());

	}

	@Override
	public int compareTo(MusicalInstrument o) {
		if (this.getBrand().equals(o.getBrand())) {
			if (this.getPrice().doubleValue() == o.getPrice().doubleValue())
				return 0;
			else if (this.getPrice().doubleValue() < o.getPrice().doubleValue())
				return -1;
			else
				return 1;
		}
		return this.getBrand().compareTo(o.getBrand());
	}

	abstract public Object clone() throws CloneNotSupportedException;
}
