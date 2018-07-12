package application;
/**
 * @author Itai Cohen
 */
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class stringAddPanel extends saxophoneAddPanel {
	private String stringNumPromt;
	private TextField numOfString = new TextField();

	@Override
	protected GridPane updateGridPane() {
		GridPane gridPane = super.updateGridPane();
		numOfString.setPromptText(stringNumPromt);
		super.LocationPlusOne();
		gridPane.add(new Label("Number of String:"), 0, super.getLocation());
		gridPane.add(numOfString, 1, super.getLocation());
		return gridPane;
	}

	public TextField getNumOfString() {
		return this.numOfString;
	}

	public void setStringNumPromt(String stringNumPromt) {
		this.stringNumPromt = stringNumPromt;
	}
}