import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Itai Cohen
 */
public class Guitar extends StringInstruments {
	private final String[] types = { "electric", "acoustic", "classic" };
	private final int minGuitarCordsNum = 6;
	private final int maxGuitarCordsNum = 8;
	private String type;

	public Guitar(Scanner fileReader) throws Exception {
		super(fileReader);
		String cordNum = fileReader.next();
		setType(fileReader.next());
		setCordsNum(Integer.parseInt(cordNum));
	}

	public Guitar(double price, String companyName, int cordsNum, String type) {
		super(price, companyName);
		setType(type);
		setCordsNum(cordsNum);

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
				throw new InputMismatchException(
						"Type of a Guitar must be one of these: Electric, Acoustic, Classic not " + this.type);
		} catch (InputMismatchException ex) {
			System.err.println(ex.getMessage());
			System.exit(0);
		}
	}

	public String getType() {
		return type;
	}

	@Override
	public void setCordsNum(int cordsNum) {
		try {
			if (type.equalsIgnoreCase(types[1]) || this.type.equalsIgnoreCase(types[2])) { // acoustic, classic
				if (cordsNum != minGuitarCordsNum)
					throw new InputMismatchException(getType() + " Guitars have 6 strings, not " + cordsNum);
				else
					super.setCordsNum(cordsNum);
			} else if (type.equalsIgnoreCase(types[0])) { // electric
				if (cordsNum >= minGuitarCordsNum && cordsNum <= maxGuitarCordsNum)
					super.setCordsNum(cordsNum);
				else
					throw new InputMismatchException("Electric number of strings is a number between "
							+ minGuitarCordsNum + " and " + maxGuitarCordsNum);
			}
		} catch (InputMismatchException ex) {
			System.err.println(ex.getMessage());
			super.setCordsNum(6); // default //Itzik confirmed
			System.exit(0);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Guitar) {
			Guitar i = (Guitar) o;
			return (super.getPrice() == i.getPrice() && super.stringEqual(super.getCompanyName(), i.getCompanyName())
					&& super.getCordsNum() == i.getCordsNum() && super.stringEqual(this.getType(), i.getType()));
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " Type: " + type;
	}
}