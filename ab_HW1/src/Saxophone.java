import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Itai Cohen
 */
public class Saxophone extends WindInstruments {

	public Saxophone(Scanner fileReader) throws Exception {
		super(fileReader);
	}

	public Saxophone(double price, String companyName) {
		super(price, companyName, "metal");
	}

	@Override
	public void setMaterial(String material) {
		material = material.toLowerCase();
		try {
			if (!material.equals(materials[1])) // metal
				throw new InputMismatchException("Material of a Saxophone must be Metal");
			else
				super.setMaterial(materials[1]);
		} catch (InputMismatchException ex) {
			System.err.println(ex.getMessage());
			System.exit(0);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Saxophone) {
			Saxophone i = (Saxophone) o;
			return (super.getPrice() == i.getPrice() && super.stringEqual(super.getCompanyName(), i.getCompanyName()));
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
