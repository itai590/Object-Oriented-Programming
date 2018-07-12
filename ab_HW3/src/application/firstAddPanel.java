package application;

/**
 * @author Itai Cohen
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class firstAddPanel {// extends Application{
	public final static String[] INSTRUMENTS_TYPES = { "Guitar", "Bass", "Flute", "Saxophone" };
	public final static int GUITAR = 0, BASS = 1, FLUTE = 2, SAXOPHONE = 3;

	private String title = "Afeka Instruments - add new instrument";
	private ComboBox<String> InstrumentsTypeComboBox = new ComboBox<>();
	private int location = 0; // for gridPane smart locate item

	public firstAddPanel() {

		InstrumentsTypeComboBox.setPromptText("Choose Instrument Type Here");

		for (int i = 0; i < INSTRUMENTS_TYPES.length; i++) {
			InstrumentsTypeComboBox.getItems().add(INSTRUMENTS_TYPES[i]);
		}

		InstrumentsTypeComboBox.setOnAction(e -> {
			Scene scene = null;
			switch (indexOfType()) {
			case GUITAR:
				guitarAddPanel gap = new guitarAddPanel();
				gap.getTypeComboBox().setPromptText(INSTRUMENTS_TYPES[GUITAR]);
				VBox vb = gap.updateVbox();
				scene = new Scene(vb, 350, 300);
				break;

			case BASS:
				bassAddPanel bap = new bassAddPanel();
				bap.getTypeComboBox().setPromptText(INSTRUMENTS_TYPES[BASS]);
				vb = bap.updateVbox();
				scene = new Scene(vb, 350, 300);
				break;

			case FLUTE:
				fluteAddPanel fap = new fluteAddPanel();
				fap.getTypeComboBox().setPromptText(INSTRUMENTS_TYPES[FLUTE]);
				vb = fap.updateVbox();
				scene = new Scene(vb, 350, 300);
				break;

			case SAXOPHONE:
				saxophoneAddPanel sap = new saxophoneAddPanel();
				vb = sap.updateVbox();
				scene = new Scene(vb, 350, 300);
				sap.getTypeComboBox().setPromptText(INSTRUMENTS_TYPES[SAXOPHONE]);
				break;
			}
			primaryWindow.addWindow.setScene(scene);
		});
	}

	protected GridPane updateGridPane() {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.accessibleHelpProperty();
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		gridPane.setAlignment(Pos.CENTER);
		return gridPane;
	}

	protected VBox updateVbox() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.getChildren().addAll(InstrumentsTypeComboBox);
		vbox.setAlignment(Pos.CENTER);
		return vbox;
	}

	private int indexOfType() {
		for (int i = 0; i < INSTRUMENTS_TYPES.length; i++) {
			if (this.InstrumentsTypeComboBox.getValue().equals(INSTRUMENTS_TYPES[i])) {
				return i;
			}
		}
		return 0;
	}

	public String getTitle() {
		return title;
	}

	public int getLocation() {
		return location;
	}

	public void LocationPlusOne() {
		this.location++;
	}

	public ComboBox<String> getTypeComboBox() {
		return InstrumentsTypeComboBox;
	}
}