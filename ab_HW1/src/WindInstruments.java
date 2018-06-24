import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Itai Cohen
 */
public class WindInstruments extends Instrument {
	protected final String[] materials = { "wood", "metal", "plastic" };
	private String material;

	public WindInstruments(Scanner fileReader) throws Exception {
		super(fileReader);
		setMaterial(fileReader.next());
	}

	public WindInstruments(double price, String companyName, String material) {
		super(price, companyName);
		setMaterial(material);
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		material = material.toLowerCase();
		boolean flag = false;
		for (int i = 0; i < materials.length; i++) {
			if (material.equals(materials[i])) {
				flag = true;
				this.material = material;
			}
		}
		if (!flag)
			throw new InputMismatchException();
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%s %16s|", " Made of:", material);

	}
}
