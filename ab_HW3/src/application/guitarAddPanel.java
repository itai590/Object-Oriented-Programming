package application;
/**
 * @author Itai Cohen
 */
import java.util.InputMismatchException;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class guitarAddPanel extends stringAddPanel {
	private ComboBox<String> typeComboBox = new ComboBox<>();

	private int numOfStringInt;
	private String type;

	public guitarAddPanel() {
		super.getFinalAddBt().setOnAction(e -> {
			createMusicalInstument();
		});
	}

	@Override
	public void createMusicalInstument() {
		boolean msgSent = false;
		try {
			msgSent = updateBrandPrice();
			Guitar g = (Guitar) generateMusicalInstrument(msgSent);
			primaryWindow.addInstrument(g);

			primaryWindow.updateCenterViewText(primaryWindow.getCurrentIndex());

		} catch (IllegalArgumentException ex) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(ex, "guitarAddPanel", "createMusicalInstument()",
						"Illegal Argument Exception");
			}

		} catch (InputMismatchException ex) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(ex, "guitarAddPanel", "createMusicalInstument()",
						"Input Mismatch Exception");
			}
		}
	}

	@Override
	public MusicalInstrument generateMusicalInstrument(boolean msgSent) {
		Guitar g = null;
		try {

			g = buildGguitar(getBrandStr(), getPriceDouble(), getPriceInt(), numOfStringInt, type);

		} catch (InputMismatchException e) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(e, "guitarAddPanel", "generateMusicalInstrument()",
						"Input Mismatch Exception");
			}
		}
		return g;
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

			if (typeComboBox.getValue() == null) {
				type = "empty";
				throw new InputMismatchException("Please select Type, type can't be empty");
			}

			type = typeComboBox.getValue();

		} catch (InputMismatchException ex) {
			if (!msgSent) {
				msgSent = alertMessages.genralExceptionAlert(ex, "guitarAddPanel", "updateBrandPrice()",
						"Input Mismatch Exception");
			}
		} catch (NumberFormatException ex) {
			if (!msgSent) {
				msgSent = alertMessages.genralExceptionAlert(ex, "Number Of String must be a number", "guitarAddPanel", "updateBrandPrice()",
						"Number Format Exception");
			}
		}

		return msgSent;
	}

	@Override
	protected GridPane updateGridPane() {
		super.setBrandPromt("Ex: Gibson");
		super.setPricePromt("Ex: 7500");
		super.setStringNumPromt("Ex: 6");

		GridPane gridPane = super.updateGridPane();

		typeComboBox.setPromptText("Type");
		for (int i = 0; i < Guitar.GUITAR_TYPE.length; i++) {
			typeComboBox.getItems().add(Guitar.GUITAR_TYPE[i]);
		}
		super.LocationPlusOne();
		gridPane.add(new Label("Guitar Type:"), 0, super.getLocation());
		gridPane.add(typeComboBox, 1, super.getLocation());
		return gridPane;
	}
}