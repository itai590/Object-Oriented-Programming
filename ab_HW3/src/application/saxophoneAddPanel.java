package application;
/**
 * @author Itai Cohen
 */
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.InputMismatchException;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class saxophoneAddPanel extends firstAddPanel {
	private String brandPromt;
	private String pricePromt;
	private Button FinalAddBt = new Button("Add");

	private TextField brand = new TextField();
	private TextField price = new TextField();

	private double priceDouble;
	private int priceInt;
	private String brandStr;
	

	public saxophoneAddPanel() {
		FinalAddBt.setOnAction(e -> {
			createMusicalInstument();
		});
	}

	public void createMusicalInstument() {
		boolean msgSent = false;
		try {
			msgSent = updateBrandPrice();
			Saxophone s = (Saxophone) generateMusicalInstrument(msgSent);
			primaryWindow.addInstrument(s);
			primaryWindow.updateCenterViewText(primaryWindow.getCurrentIndex());

		} catch (IllegalArgumentException ex) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(ex, "saxophoneAddPanel", "createMusicalInstument()",
						"Illegal Argument Exception");
			}

		} catch (InputMismatchException ex) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(ex, "saxophoneAddPanel", "nMethod:createMusicalInstument()",
						"Input Mismatch Exception");
			}
		}
	}

	public boolean updateBrandPrice() {
		boolean msgSent = false;
		String brandStr;
		Number priceNumber;
		try {
			brandStr = brand.getText();
			priceNumber = 1;

			if (brandStr.isEmpty())
				throw new InputMismatchException("Brand empty");

			if (price.getText().isEmpty())
				throw new InputMismatchException("Price empty");

			priceNumber = NumberFormat.getInstance().parse(price.getText());
			double priceDouble = priceNumber.doubleValue();
			int priceInt = priceNumber.intValue();

			this.priceDouble = priceDouble;
			this.priceInt = priceInt;
			this.brandStr = brandStr;

		} catch (InputMismatchException ex) {
			msgSent = alertMessages.genralExceptionAlert(ex, "", "saxophoneAddPanel", "updateBrandPrice()",
					"Input Mismatch Exception");

		} catch (ParseException ex) {
			msgSent = alertMessages.genralExceptionAlert(ex, "Price must be a Number", "saxophoneAddPanel",
					"updateBrandPrice()", "Parse Exception");
		}
		return msgSent;
	}

	public MusicalInstrument generateMusicalInstrument(boolean msgSent) {
		Saxophone s = null;
		try {
			s = buildSaxophone(brandStr, priceDouble, priceInt);
		} catch (InputMismatchException ex) {
			if (!msgSent) {
				alertMessages.genralExceptionAlert(ex, "", "saxophoneAddPanel", "generateMusicalInstrument()",
						"Input Mismatch Exception");
			}
		}
		return s;
	}

	public Saxophone buildSaxophone(String brandStr, double priceDouble, int priceInt) {
		if (priceDouble - priceInt > 0)
			return new Saxophone(brandStr, priceDouble);
		else
			return new Saxophone(brandStr, priceInt);

	}

	public Guitar buildGguitar(String brandStr, double priceDouble, int priceInt, int NumOfString, String type) {
		if (priceDouble - priceInt > 0)
			return new Guitar(brandStr, priceDouble, NumOfString, type);
		else
			return new Guitar(brandStr, priceInt, NumOfString, type);
	}

	public Bass buildBass(String brandStr, double priceDouble, int priceInt, int NumOfString, Boolean Fretless) {
		if (priceDouble - priceInt > 0)
			return new Bass(brandStr, priceDouble, NumOfString, Fretless);
		else
			return new Bass(brandStr, priceInt, NumOfString, Fretless);
	}

	public Flute buildFlute(String brandStr, double priceDouble, int priceInt, String type, String material) {
		if (priceDouble - priceInt > 0)
			return new Flute(brandStr, priceDouble, type, material);
		else
			return new Flute(brandStr, priceInt, type, material);
	}

	@Override
	protected GridPane updateGridPane() {
		GridPane gridPane = super.updateGridPane();
		brand.setPromptText(brandPromt);
		gridPane.add(new Label("Brand:"), 0, super.getLocation());
		gridPane.add(brand, 1, super.getLocation());

		super.LocationPlusOne();
		price.setPromptText(pricePromt);
		gridPane.add(new Label("Price:"), 0, super.getLocation());
		gridPane.add(price, 1, super.getLocation());
		return gridPane;
	}

	@Override
	protected VBox updateVbox() {
		VBox vbox = super.updateVbox();
		vbox.getChildren().addAll(updateGridPane(), FinalAddBt);
		return vbox;
	}

	public double getPriceDouble() {
		return priceDouble;
	}

	public int getPriceInt() {
		return priceInt;
	}

	public String getBrandStr() {
		return brandStr;
	}

	public void setBrandPromt(String brandPromt) {
		this.brandPromt = brandPromt;
	}

	public void setPricePromt(String pricePromt) {
		this.pricePromt = pricePromt;
	}

	public Button getFinalAddBt() {
		return this.FinalAddBt;
	}

	public void setBrand(TextField brand) {
		this.brand = brand;
	}
}