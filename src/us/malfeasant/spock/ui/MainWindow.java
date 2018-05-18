package us.malfeasant.spock.ui;

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
				if (!showQuitDialog()) {
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
				if (showQuitDialog()) {
					Platform.exit();
				}
			}
		});
		Menu fileMenu = new Menu("File", null, itemNew, itemOpen, itemExit);
		
		return new MenuBar(fileMenu);
	}
	
	private boolean changed = true;	// TODO: track whether design has been changed since last save- in this class or design class?
	/**
	 * @return true if ok to close, false if dialog was cancelled or there was a problem saving file...
	 */
	private boolean showQuitDialog() {
		if (changed) {
			ButtonType yes = ButtonType.YES;
			ButtonType no = ButtonType.NO;
			ButtonType cancel = ButtonType.CANCEL;
			Alert alert = new Alert(AlertType.CONFIRMATION, "Design has changed, save it?");
			alert.getButtonTypes().setAll(yes, no, cancel);
			alert.showAndWait().ifPresent(response -> {
				if (response == ButtonType.YES) {
					// TODO: save dialog- assuming success, 
					changed = false;
				} else if (response == ButtonType.NO) {
					// go ahead and exit
					changed = false;
				} else {
					
				}
			});
		}
		
		return !changed;
	}
}
