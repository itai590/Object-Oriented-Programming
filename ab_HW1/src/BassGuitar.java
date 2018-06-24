import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Itai Cohen
 */
public class BassGuitar extends StringInstruments {
	private final int  minCordNum=4;
	private final int maxCordNum=6;
	private boolean fretless;

	public BassGuitar(Scanner fileReader) throws Exception {
		super(fileReader);
		setCordsNum(Integer.parseInt(fileReader.next()));
		setFretless(fileReader.next());
	}

	public BassGuitar(double price, String companyName, int setCordsNum, boolean fretless) {
		super(price, companyName);
		setCordsNum(setCordsNum);
		setFretless(fretless);
	}

	@Override
	public void setCordsNum(int cordsNum) {
		try {
			if (cordsNum >= minCordNum && cordsNum <= maxCordNum)
				super.setCordsNum(cordsNum);
			else
				throw new InputMismatchException("Bass number of strings is a number between "+minCordNum+" and " +maxCordNum);
		} catch (InputMismatchException ex) {
			System.err.println(ex.getMessage());
			System.exit(0);
		}
	}

	public boolean isFretless() {
		return fretless;
	}

	public void setFretless(boolean fretless) {
		this.fretless = fretless;
	}

	public void setFretless(String fretless) {
		try {
			if (fretless.equalsIgnoreCase("true"))
				setFretless(true);
			else if (fretless.equalsIgnoreCase("false"))
				setFretless(false);
			else
				throw new InputMismatchException(
						"Whether a bass is fretless or not is boolean, any other string than \"True\" or \"False\" is not acceptable");
		} catch (InputMismatchException ex) {
			System.err.println(ex.getMessage());
			System.out.print("[fretless is " + fretless + "]");
			System.exit(0);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof BassGuitar) {
			BassGuitar i = (BassGuitar) o;
			return (super.getPrice() == i.getPrice() && super.stringEqual(super.getCompanyName(), i.getCompanyName())
					&& super.getCordsNum() == i.getCordsNum() && this.isFretless() == i.isFretless());
		}
		return false;
	}

	@Override
	public String toString() {
		String str;
		if (fretless)
			str = "Yes";
		else
			str = "No";
		return super.toString() + " Fretless: " + str;
	}

}
