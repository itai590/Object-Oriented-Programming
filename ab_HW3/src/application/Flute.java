package application;
/**
 * Itai Cohen
 * @version 1
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Flute extends WindInstrument {
	public static final String[] FLUTE_TYPE = { "Flute", "Recorder", "Bass" };
	private String fluteType;

	public Flute(String brand, Number price, String material, String fluteType) {
		super(brand, price, material);
		setFluteType(fluteType);
	}

	public Flute(Scanner scanner) {
		super(scanner);
		setFluteType(scanner.nextLine());
	}

	public String getFluteType() {
		return fluteType;
	}

	public void setFluteType(String fluteType) {
		if (!isFluteType(fluteType))
			throw new InputMismatchException("Invalid flute type: " + fluteType);

		this.fluteType = fluteType;
	}

	private boolean isFluteType(String input) {
		return isValidType(FLUTE_TYPE, input);
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		if (!(o instanceof Flute))
			return false;

		return getFluteType().equals(((Flute) o).getFluteType());
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" Type: %7s", getFluteType().toString());
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Flute newFlute = new Flute(super.getBrand(), super.getPrice(), super.getMaterial(), this.fluteType);
		return newFlute;
	}

}
