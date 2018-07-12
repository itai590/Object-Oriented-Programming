package application;
/**
 * @author Itai Cohen
 * @version 1
 * @version 2:
 		-updateCenterViewText()
		-rotateInstrumentsLeft()
		-rotateInstrumentsRight()
		-getters and setters added
		-KeyBoardHandler()
		-setOnAction methods added
		-CenterView not static any more
		-all class property are privatestartAfeka.searchAfeka
*/
import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class primaryWindow extends Application {

	private String title = "Afeka Instrument Music Store";
	private TopView topView = new TopView();
	private BottomView bottomView = new BottomView();
	private static CenterView centerView = new CenterView();
	private LeftView leftView = new LeftView();
	private RightView rightView = new RightView();
	private static ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
	private static int currentIndex = 0;
	protected static Stage addWindow = new Stage();

	public static ArrayList<MusicalInstrument> getAllInstruments() {
		return allInstruments;
	}

	protected BorderPane createMainPane() {
		BorderPane pane = new BorderPane();
		pane.setRight(this.rightView);
		pane.setLeft(this.leftView);
		pane.setTop(this.topView);
		pane.setBottom(this.bottomView);
		pane.setCenter(centerView);
		pane.setPadding(new Insets(10, 10, 10, 10));
		return pane;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		startAfeka(allInstruments);

		Scene scene = new Scene(createMainPane(), 1000, 350);
		Stage window = new Stage();
		window.setMinHeight(350);
		window.setMinWidth(1000);
		window.setTitle(getTitle()); // Set the stage title
		window.setScene(scene); // Place the scene in the stage
		window.show(); // Display the stage
		// primaryStage.setAlwaysOnTop(true);

		// set all relevant keyboard keys to work
		KeyBoardHandler(window);

		// buttons
		SearchBt_setOnAction();
		addBt_setOnAction();
		deleteBt_setOnAction();
		clearBt_setOnAction();

		// window close button
		window.setOnCloseRequest(e -> {
			this.bottomView.stopClockTextOnExit();
		});
	}

	// **Methods**//

	public static String removeInstrument(int index) {
		allInstruments.remove(index);
		return "Instrument Deleted Successfully!";
	}

	public static int getCurrentIndex() {
		return currentIndex;
	}

	public static void addInstrument(MusicalInstrument m) {
		if (!(m == null)) {
			allInstruments.add(m);
			currentIndex = allInstruments.size() - 1;
			// System.out.println();
			// AfekaInstruments.printInstruments(allInstruments);
			// setSorted(false);}
			primaryWindow.addWindow.close();
		}
	}

	public void startAfeka(ArrayList<MusicalInstrument> searchResInstrument) {
		File file = AfekaInstruments.getInstrumentsFileFromUser(AfekaInstruments.showFileInputDialog());
		AfekaInstruments.loadInstrumentsFromFile(file, allInstruments);
		if (allInstruments.size() == 0) {
			alertMessages.ArrayEmptyMsg();
			return;
		}
		updateCenterViewText(currentIndex);
		// AfekaInstruments.printInstruments(allInstruments);
	}

	public void searchAfeka(ArrayList<MusicalInstrument> searchResInstrument) {
		if (searchResInstrument.size() == 0) {
			alertMessages.NotFoundMsg();
			return;
		} else {
			currentIndex = 0;
			allInstruments.clear();
			allInstruments = searchResInstrument;
			updateCenterViewText(currentIndex);
		}
		// AfekaInstruments.printInstruments(searchResInstrument);
	}

	protected static void updateCenterViewText(int index) {//,Stage window) {
		try {
			centerView.SetTypeField(allInstruments.get(index).getClass().getSimpleName());
			centerView.SetBrandField(allInstruments.get(index).getBrand());
			centerView.SetPriceField(allInstruments.get(index).getPrice());
		} catch (NullPointerException ex) {
		}
	}

	public void rotateInstrumentsLeft() {
		if (allInstruments.size() > 0) {
			if (currentIndex == 0)
				currentIndex = allInstruments.size() - 1;
			else
				currentIndex--;
			updateCenterViewText(currentIndex);
		} else
			alertMessages.ArrayEmptyMsg();
	}

	public void rotateInstrumentsRight() {
		if (allInstruments.size() > 0) {
			if (currentIndex == allInstruments.size() - 1)
				currentIndex = 0;
			else
				currentIndex++;
			updateCenterViewText(currentIndex);
		} else
			alertMessages.ArrayEmptyMsg();
	}

	public void KeyBoardHandler(Stage primaryStage) {
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
			if (ev.getCode() == KeyCode.DELETE) {
				this.bottomView.getTopBottomView().setDeleteBtOnFire();
			}
			if (ev.getCode() == KeyCode.ENTER) {
				this.topView.setSearchBtOnFire();
			}
			if (ev.getCode() == KeyCode.A) {
				this.bottomView.getTopBottomView().setAddBtOnFire();
			}
		});
	}

	public void addBt_setOnAction() {
		this.bottomView.getTopBottomView().getAddBt().setOnAction(e -> {
			firstAddPanel fm = new firstAddPanel();
			VBox vb = fm.updateVbox();
			Scene scene = new Scene(vb, 350, 375);
			addWindow.setHeight(350);
			addWindow.setWidth(375);
			addWindow.setMinHeight(375);
			addWindow.setMinWidth(300);
			addWindow.setTitle(fm.getTitle());

			// Cannot set modality once stage has been set visible - fix
			if (!addWindow.getModality().equals(Modality.APPLICATION_MODAL))
				addWindow.initModality(Modality.APPLICATION_MODAL);
			addWindow.setAlwaysOnTop(true);
			addWindow.setScene(scene); // Place the scene in the stage
			addWindow.showAndWait(); // Display the stage

			addWindow.setOnCloseRequest(ev -> {

				addWindow.close();
			});
		});
	}

	public void deleteBt_setOnAction() {
		this.bottomView.getTopBottomView().getDeleteBt().setOnAction(e -> {
			if (allInstruments.size() <= 0 || allInstruments == null) {
				alertMessages.ArrayEmptyMsg();

			} else {

				if (allInstruments.size() == 1) {
					alertMessages.deleteMsg(removeInstrument(currentIndex));
					centerView.clearFields();
					alertMessages.ArrayEmptyMsg();
				} else if (currentIndex == allInstruments.size() - 1) {
					alertMessages.deleteMsg(removeInstrument(currentIndex));
					currentIndex = 0;
					updateCenterViewText(currentIndex);
				} else {
					alertMessages.deleteMsg(removeInstrument(currentIndex));
					updateCenterViewText(currentIndex);
				}
			}
			// System.out.println();
			// AfekaInstruments.printInstruments(allInstruments);
		});
	}

	public void clearBt_setOnAction() {
		this.bottomView.getTopBottomView().getClearBt().setOnAction(e -> {
			AfekaInventory<MusicalInstrument> aInv = new AfekaInventory<MusicalInstrument>(allInstruments);
			alertMessages.clearAllMsg(aInv.removeAll(aInv.getList()));
			centerView.clearFields();
		});
	}

	public void SearchBt_setOnAction() {
		this.topView.getSearchBt().setOnAction(e -> {
			String key = this.topView.getSearchField().getText();
			if (key.length() == 0) {
				alertMessages.searchEmptyMsg();
			} else {
				AfekaInventory<MusicalInstrument> aInv = new AfekaInventory<MusicalInstrument>(allInstruments);
				ArrayList<MusicalInstrument> searchResInstrument = aInv.SearchByKey(aInv.getList(), key);
				searchAfeka(searchResInstrument);
			}
		});
	}

	// inner class 1: LeftView
	public class LeftView extends VBox {
		private Button leftBt = new Button("<");

		// constructor
		public LeftView() {
			getChildren().add(leftBt);
			setAlignment(Pos.CENTER);
			leftBt.setOnAction(e -> rotateInstrumentsLeft());
		}
	}

	// inner class 2: RightView
	public class RightView extends VBox {
		private Button rightBt = new Button(">");

		// constructor
		public RightView() {
			getChildren().add(rightBt);
			setAlignment(Pos.CENTER);
			rightBt.setOnAction(e -> rotateInstrumentsRight());
		}
	}

	public String getTitle() {
		return title;
	}
}
