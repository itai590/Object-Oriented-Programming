package application;

/**
 * @author Itai Cohen
 * @version 1
 * @version 2: getters and setters
*/
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class BottomView extends VBox {
	private Timeline timeline;
	private PathTransition pathTransition;
	private Text redTxt = new Text();
	private topBottomView topBottomView = new topBottomView();

	public void stopClockTextOnExit() {
		getTimeline().stop();
		getPathTransition().stop();
	}

	// constructor
	public BottomView() {
		setPadding(new Insets(10, 10, 10, 10));
		setSpacing(10);

		// date and clock display and update every 1 second
		this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String timeTxt = time.format(timeFormatter);
			redTxt.setText(date + " " + timeTxt
					+ " Afeka Instrument Music Store $$$ ON SALE!!! $$$ Guitars, Basses, Flutes, Saxophones, and more!");
		}));
		this.timeline.setCycleCount(Animation.INDEFINITE);
		this.timeline.play();

		// Text Movement
		this.pathTransition = new PathTransition();
		this.pathTransition.setDuration(Duration.seconds(10));
		this.pathTransition.setNode(redTxt);
		Line lineMvmnt = new Line();
		lineMvmnt.setStartX(250);
		lineMvmnt.setEndX(700);
		this.pathTransition.setPath(lineMvmnt);
		this.pathTransition.setAutoReverse(true);
		this.pathTransition.setCycleCount(PathTransition.INDEFINITE);
		this.pathTransition.play();

		this.redTxt.setOnMouseEntered(e -> pathTransition.pause());
		this.redTxt.setOnMouseExited(e -> pathTransition.play());

		setSpacing(10);
		setAlignment(Pos.CENTER);
		this.redTxt.setFill(Color.RED);
		Font fontBold = Font.font(redTxt.getFont().getName(), FontWeight.BOLD, redTxt.getFont().getSize());
		this.redTxt.setFont(fontBold);

		getChildren().addAll(this.topBottomView, this.redTxt);
		}	
	


	public Timeline getTimeline() {
		return timeline;
	}

	public void setRedTxt(Text redTxt) {
		this.redTxt = redTxt;
	}

	public PathTransition getPathTransition() {
		return pathTransition;
	}

	public topBottomView getTopBottomView() {
		return topBottomView;
	}

	public void setTopBottomView(topBottomView topBottomView) {
		this.topBottomView = topBottomView;
	}

	// Inner class
	protected class topBottomView extends HBox {
		private Button addBt = new Button("Add");
		private Button deleteBt = new Button("Delete");
		private Button clearBt = new Button("Clear");

		public topBottomView() {
			setPadding(new Insets(10, 10, 10, 10));
			setSpacing(10);
			setAlignment(Pos.CENTER);
			getChildren().addAll(addBt, deleteBt, clearBt);
		}

		public Button getAddBt() {
			return addBt;
		}

		public Button getClearBt() {
			return clearBt;
		}

		public Button getDeleteBt() {
			return deleteBt;
		}

		public void setDeleteBtOnFire() {
			this.deleteBt.fire();
		}
		
		public void setAddBtOnFire() {
			this.addBt.fire();
		}
	}
}
