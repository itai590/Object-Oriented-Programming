package gui_random_ex;
/**
 * @author itai 
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//new button in a scene
//for each button you need a stage
//stage > scene > container > node
public class guiRandomClass extends Application {
	private TextField textField = new TextField();
	private final int N = 10;
	private int guessCount = 0;
	private final int randomNumber = (int) (Math.random() * N);
	private Text label1 = new Text();
	private Text label2 = new Text();
	private Text label3 = new Text();
	private Text label4 = new Text();
	private Button checkBt = new Button();
	private int userGuess = -1; // init

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) { // Create a button and place it in the scene
		checkBt.setText("Check");
		// checkBt.setMaxSize(20, 20);
		textField.setMaxSize(100, 20);
		label1.setText("Insert Number:");
		label2.setText("\nTry " + (guessCount + 1) + "/" + N);
		label4.setText("  Welcome to the right guess game! \nYou need to guess the number (0 to "+N+").\nYou have 10 Attempts for that.");
		BorderPane bp = new BorderPane();
		VBox vb2 = new VBox(); // just to center lable2
		StackPane sp3 = new StackPane(); // just to center lable3
		StackPane sp4 = new StackPane(); // just to center textField
		bp.setPadding(new Insets(10, 10, 10, 10));
		bp.setLeft(label1);
		vb2.getChildren().addAll(label4,label2);
		vb2.setAlignment(Pos.TOP_CENTER);
		bp.setTop(vb2);
		sp3.getChildren().add(label3);
		bp.setTop(vb2);
		sp4.getChildren().add(textField);
		sp4.setAlignment(Pos.TOP_LEFT);
		bp.setCenter(sp4);
		bp.setRight(checkBt);
		bp.setBottom(sp3);
		Scene scene = new Scene(bp, 315, 165);
		primaryStage.setTitle("GUI Random Guess"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		primaryStage.setAlwaysOnTop(true);
		checkBt.setOnAction(e -> guessCheck());
		checkBt.defaultButtonProperty();
		checkBt.setDefaultButton(true);
	}

	private void guessCheck() {
		label3.setText("");
		System.out.println("rnum:" + randomNumber);
		try {
			userGuess = Integer.parseInt(textField.getText());

			if (userGuess == randomNumber) {
				label3.setText("Bingo! \nProgram finished");
				checkBt.setText("Close");
				checkBt.setOnAction(e -> System.exit(0));
			}
			guessCount++;
			textField.clear();
			label2.setText("\nTry " + (guessCount + 1) + "/" + N);
			if (guessCount == N - 1)
				label2.setText("\nLast try!");

			if (guessCount == N) {
				label2.setText("\nSorry, you didnt guess the number :(");
				label3.setText("The number is:" + randomNumber + "\nProgram finished");
				textField.backward();
				checkBt.setText("Close");
				checkBt.setOnAction(e -> System.exit(0));
			}
		} catch (NumberFormatException ex) {
			label3.setText("Invalid input, please try again");
			textField.clear();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
