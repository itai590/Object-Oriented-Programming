package application;
/**
 * @author Itai Cohen
 * @version 1
 * @version 2: getters and setters
*/
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TopView extends HBox {
	private Button searchBt = new Button("Go!");
	private TextField searchField = new TextField();

	// constructor
	public TopView() {
		setPadding(new Insets(10, 10, 10, 10));
		searchField.setPrefWidth(800);
		setSpacing(10);
		// setPrefSize(1100, 50);
		setAlignment(Pos.CENTER);
		searchField.setPromptText("Search...");
		getChildren().addAll(searchField, searchBt);
	}

	public TextField getSearchField() {
		return searchField;
	}

	public Button getSearchBt() {
		return searchBt;
	}
	
	public void setSearchBtOnFire() {
		searchBt.fire();
	}
}
