package application;
/**
 * @author Itai Cohen
 */
import java.util.InputMismatchException;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class bassAddPanel extends stringAddPanel {
	private CheckBox fretless = new CheckBox();
	private int numOfStringInt;
	private boolean fretlessBoolean;
	


	public bassAddPanel() {
		super.getFinalAddBt().setOnAction(e -> {
			createMusicalInstument();
		});
	}

	@Override
	public void createMusicalInstument() {
		boolean msgSent = false;
		try {
			msgSent = updateBrandPrice();
			Bass b = (Bass) generateMusicalInstrument(msgSent);
			primaryWindow.addInstrument(b);

			primaryWindow.updateCenterViewText(primaryWindow.getCurrentIndex());

		} catch (IllegalArgumentException ex) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(ex, "bassAddPanel", "createMusicalInstument()",
						"Illegal Argument Exception");
			}

		} catch (InputMismatchException ex) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(ex, "bassAddPanel", "createMusicalInstument()",
						"Input Mismatch Exception");
			}
		}
	}

	@Override
	public MusicalInstrument generateMusicalInstrument(boolean msgSent) {
		Bass b = null;
		try {
			b = buildBass(getBrandStr(), getPriceDouble(), getPriceInt(), numOfStringInt, fretlessBoolean);

		} catch (InputMismatchException e) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(e, "bassAddPanel", "generateMusicalInstrument()",
						"Input Mismatch Exception");
			}
		}
		return b;
	}

	@Override
	public boolean updateBrandPrice() {
		boolean msgSent = super.updateBrandPrice();
		try {

			if (super.getNumOfString().getText().isEmpty()) {
				throw new InputMismatchException("number Of String empty");
			}
			int localNumOfStringInt = Integer.parseInt(super.getNumOfString().getText());

			numOfStringInt = localNumOfStringInt;

			if (this.fretless.isSelected())
				fretlessBoolean = true;
			else
				fretlessBoolean = false;

		} catch (InputMismatchException ex) {
			if (!msgSent) {
				msgSent = alertMessages.genralExceptionAlert(ex, "bassAddPanel", "updateBrandPrice()",
						"Input Mismatch Exception");
			}
		} catch (NumberFormatException ex) {
			if (!msgSent) {
				msgSent = alertMessages.genralExceptionAlert(ex,"Number Of String must be a number", "bassAddPanel", "updateBrandPrice()",
						"Number Format Exception");
			}
		}

		return msgSent;
	}

	@Override
	protected GridPane updateGridPane() {
		super.setBrandPromt("Ex: Fender Jazz");
		super.setPricePromt("Ex: 7500");
		super.setStringNumPromt("Ex: 4");

		GridPane gridPane = super.updateGridPane();

		super.LocationPlusOne();
		gridPane.add(new Label("Fretless:"), 0, super.getLocation());
		gridPane.add(fretless, 1, super.getLocation());
		return gridPane;
	}
}
