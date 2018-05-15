package us.malfeasant.spock.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
				showQuitDialog();	// TODO: make use of return
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
				showQuitDialog();	// TODO: make use of return
			}
		});
		Menu fileMenu = new Menu("File", null, itemNew, itemOpen, itemExit);
		
		return new MenuBar(fileMenu);
	}
	
	/**
	 * @return true if ok to close, false if dialog was cancelled or there was a problem saving file...
	 */
	private boolean showQuitDialog() {
		return true;
	}
}
