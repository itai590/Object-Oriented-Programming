package application;

/**
 * @author Itai Cohen
 * @version 1
 * @version 2: getters and setters
*/
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CenterView extends GridPane {
	private TextField txtFldType = new TextField();
	private TextField txtFldBrand = new TextField();
	private TextField txtFldPrice = new TextField();

	public CenterView() {
		setPadding(new Insets(10, 10, 10, 10));
		setAlignment(Pos.CENTER);
		setHgap(10);
		setVgap(10);

		txtFldType.setEditable(false);
		txtFldBrand.setEditable(false);
		txtFldPrice.setEditable(false);
		add(new Label("Type:"), 0, 1);
		add(new Label("Brand:"), 0, 2);
		add(new Label("Price:"), 0, 3);
		add(txtFldType, 1, 1);
		add(txtFldBrand, 1, 2);
		add(txtFldPrice, 1, 3);
	}


	protected void clearFields() {
		this.txtFldType.clear();
		this.txtFldBrand.clear();
		this.txtFldPrice.clear();
	}

	protected void SetTypeField(String type) {
		this.txtFldType.setText(type);
	}

	protected void SetBrandField(String brand) {
		this.txtFldBrand.setText(brand);
	}

	protected void SetPriceField(Number number) {
		String priceStr = String.valueOf(number);
		txtFldPrice.setText(priceStr);
	}

}
