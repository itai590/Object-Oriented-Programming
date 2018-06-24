import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Itai Cohen
 */
public class Flute extends WindInstruments {
	private final String[] types = { "flute", "bass", "recorder" };
	private String type;

	public Flute(Scanner fileReader) throws Exception {
		super(fileReader);
		setType(fileReader.next());
	}

	public Flute(double price, String companyName, String material, String type) {
		super(price, companyName, material);
		setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		type = type.toLowerCase();
		boolean isTypeLegal = false;
		for (int i = 0; i < types.length; i++) {
			if (type.equals(types[i])) {
				isTypeLegal = true;
				break;
			}
		}
		try {
			if (isTypeLegal)
				this.type = type.substring(0, 1).toUpperCase() + type.substring(1);
			else
				throw new InputMismatchException("Type must be one of these: Flute, Bass, Recorder");
		} catch (InputMismatchException ex) {
			System.err.println(ex.getMessage());
			System.out.println("[not type:" + type + "]");
			System.exit(0);
		}
	}

	@Override
	public void setMaterial(String material) {
		material = material.toLowerCase();
		try {
			super.setMaterial(material);
		} catch (InputMismatchException ex) {
			System.err.println("Material of a Flute must be one of these: Wood, Metal or Plastic only");
			System.exit(0);
		}
	}

	public String[] getTypes() {
		return types;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Flute) {
			Flute i = (Flute) o;
			return (super.getPrice() == i.getPrice() && super.stringEqual(super.getCompanyName(), i.getCompanyName())
					&& super.stringEqual(this.getType(), i.getType())
					&& super.stringEqual(super.getMaterial(), i.getMaterial()));
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " Type: " + type;
	}
}
