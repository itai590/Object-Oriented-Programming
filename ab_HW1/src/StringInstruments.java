import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Itai Cohen
 */
public class StringInstruments extends Instrument {
	private int cordsNum;

	public StringInstruments(Scanner fileReader) throws Exception {
		super(fileReader);
	}

	public StringInstruments(double price, String companyName) {
		super(price, companyName);
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%s %5s|", " Number of strings: ", cordsNum);
	}

	public int getCordsNum() {
		return cordsNum;
	}

	public void setCordsNum(int cordsNum) {
		this.cordsNum = cordsNum;
	}

}
