package application;
/**
 * @author Itai Cohen
 */
import java.util.InputMismatchException;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class fluteAddPanel extends saxophoneAddPanel {
	private ComboBox<String> materialComboBox = new ComboBox<>();
	private ComboBox<String> typeComboBox = new ComboBox<>();

	private String type;
	private String material;

	public fluteAddPanel() {
		super.getFinalAddBt().setOnAction(e -> {
			createMusicalInstument();
		});
	}

	@Override
	public void createMusicalInstument() {
		boolean msgSent = false;
		try {
			msgSent = updateBrandPrice();
			Flute f = (Flute) generateMusicalInstrument(msgSent);
			primaryWindow.addInstrument(f);

			primaryWindow.updateCenterViewText(primaryWindow.getCurrentIndex());

		} catch (IllegalArgumentException ex) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(ex, "fluteAddPanel", "createMusicalInstument()",
						"Illegal Argument Exception");
			}

		} catch (InputMismatchException ex) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(ex, "fluteAddPanel", "createMusicalInstument()",
						"nInput Mismatch Exception");
			}
		}
	}

	@Override
	public MusicalInstrument generateMusicalInstrument(boolean msgSent) {
		Flute f = null;
		try {
			f = buildFlute(getBrandStr(), getPriceDouble(), getPriceInt(), material, type);

		} catch (InputMismatchException e) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(e, "fluteAddPanel", "generateMusicalInstrument()",
						"Input Mismatch Exception");
			}
		}
		return f;
	}

	@Override
	public boolean updateBrandPrice() {
		boolean msgSent = super.updateBrandPrice();
		try {

			if (typeComboBox.getValue() == null) {
				type = "empty";
				throw new InputMismatchException("Please select Type, type can't be empty");
			}

			type = typeComboBox.getValue();

			if (materialComboBox.getValue() == null) {
				material = "empty";
				throw new InputMismatchException("Please select Material, material can't be empty");
			}

			material = materialComboBox.getValue();

		} catch (InputMismatchException ex) {
			if (!msgSent) {
				msgSent = alertMessages.genralExceptionAlert(ex, "fluteAddPanel", "updateBrandPrice()",
						"Input Mismatch Exception");
			}
		} catch (NumberFormatException ex) {
			if (!msgSent) {
				msgSent = alertMessages.genralExceptionAlert(ex, "fluteAddPanel", "updateBrandPrice()",
						"Number Format Exception");
			}
		}

		return msgSent;
	}

	@Override
	protected GridPane updateGridPane() {

		super.setBrandPromt("Ex: Levit");
		super.setPricePromt("Ex: 300");

		GridPane gridPane = super.updateGridPane();

		materialComboBox.setPromptText("Material");
		for (int i = 0; i < WindInstrument.WIND_INSTRUMENT_MATERIAL.length; i++) {
			materialComboBox.getItems().add(WindInstrument.WIND_INSTRUMENT_MATERIAL[i]);
		}

		typeComboBox.setPromptText("Type");
		for (int i = 0; i < Flute.FLUTE_TYPE.length; i++) {
			typeComboBox.getItems().add(Flute.FLUTE_TYPE[i]);
		}

		super.LocationPlusOne();
		gridPane.add(new Label("Flute Material:"), 0, super.getLocation());
		gridPane.add(materialComboBox, 1, super.getLocation());

		super.LocationPlusOne();
		gridPane.add(new Label("Flute Type:"), 0, super.getLocation());
		gridPane.add(typeComboBox, 1, super.getLocation());

		return gridPane;

	}
}