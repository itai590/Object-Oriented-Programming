package application;
/**
 * @author Itai Cohen
 * @version 1: new class
 */

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.Modality;

public class alertMessages {

	public static void genericAlertMsg(AlertType type, String title, String header, String content) {
		Alert dialog = new Alert(type);
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(content);
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		dialog.showAndWait();
	}

	// overload
	public static void genericAlertMsg(AlertType type, String title, String header) {
		genericAlertMsg(type, title, header, "");
	}

	public static boolean genralExceptionAlert(Exception ex, String additionalData, String className, String Method,
			String ExeptionType) {
		primaryWindow.addWindow.setAlwaysOnTop(false);
		alertMessages.genericAlertMsg(AlertType.ERROR, "Error", additionalData +"\n"+ex.getMessage(),
				className + "\nMethod: " + Method + "\n" + ExeptionType);
		return true;
	}

	public static boolean genralExceptionAlert(Exception ex, String className, String Method, String ExeptionType) {
		return genralExceptionAlert(ex, "", className, Method, ExeptionType);
	}

	public static void NotFoundMsg() {
		genericAlertMsg(AlertType.INFORMATION, "Array Information", "Instrument not found",
				"Search result array is empty");
	}

	public static void InstrumentsLoadedMsg() {
		genericAlertMsg(AlertType.INFORMATION, "Information", "Instruments loaded from file successfully");
	}

	public static void ArrayEmptyMsg() {
		genericAlertMsg(AlertType.INFORMATION, "Array Information", "The array is Empty",
				"There are no instruments in the store currently");
	}

	public static void searchEmptyMsg() {
		genericAlertMsg(AlertType.ERROR, "Search Error", "Invalid key search",
				"Please enter a key search (price, number, brand etc..)");
	}

	public static void clearAllMsg(String str) {
		genericAlertMsg(AlertType.INFORMATION, "Clear Information", str);
	}

	public static void deleteMsg(String str) {
		genericAlertMsg(AlertType.INFORMATION, "Delete Information", str);
	}
}
