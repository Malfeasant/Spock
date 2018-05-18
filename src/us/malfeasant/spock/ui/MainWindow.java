package us.malfeasant.spock.ui;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainWindow {
	private final Stage stage;
	private final BorderPane pane;
	
	public MainWindow(Stage primaryStage, Object design) {	// TODO: more specific than Object
		stage = primaryStage;
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				if (!checkQuit()) {
					event.consume();
				}
			}
		});
		VBox top = new VBox(makeMenu());	// TODO: add toolbar
//		pane = new BorderPane(center, top, right, bottom, left);
		pane = new BorderPane(null, top, null, null, null);
		
		stage.setScene(new Scene(pane));
		stage.show();
	}
	
	private MenuBar makeMenu() {
		MenuItem itemNew = new MenuItem("New");
		MenuItem itemOpen = new MenuItem("Open");
		MenuItem itemExit = new MenuItem("Exit");
		itemExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (checkQuit()) {
					Platform.exit();
				}
			}
		});
		Menu fileMenu = new Menu("File", null, itemNew, itemOpen, itemExit);
		
		return new MenuBar(fileMenu);
	}
	
	/**
	 * @return true if ok to close, false if dialog was cancelled or there was a problem saving file...
	 */
	private boolean checkQuit() {
		boolean changed = true;	// TODO: track whether design has been changed since last save- in this class or design class?
		if (changed) {
			return showQuitDialog();
		}
		return !changed;
	}
	/**
	 * @return true if ok to close, false if dialog was cancelled or there was a problem saving file...
	 */
	private boolean showQuitDialog() {
		boolean allowClose = false;
		ButtonType yes = ButtonType.YES;
		ButtonType no = ButtonType.NO;
		ButtonType cancel = ButtonType.CANCEL;
		Alert alert = new Alert(AlertType.CONFIRMATION, "Design has changed, save it?");
		alert.getButtonTypes().setAll(yes, no, cancel);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent()) {
			if (result.get() == ButtonType.YES) {
				// TODO: save dialog- assuming success, 
				allowClose = true;
			} else if (result.get() == ButtonType.NO) {
				// go ahead and exit... 
				allowClose = true;
			} else {
				// cancel, window was closed, something unexpected... nothing to do?
			}
		}
		return allowClose;
	}
}
