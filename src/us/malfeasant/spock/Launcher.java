package us.malfeasant.spock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import us.malfeasant.spock.editor.Editor;

public class Launcher extends Application {
	@Override
	public void start(Stage primaryStage) {
		// TODO: Read command line arguments to determine whether to start a new design, open existing, present a dialog...
		// maybe have a configurable default?  
		// TODO: we could present buttons for new or existing design...  
/*		Button startNew = new Button("New Design");
		startNew.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		startNew.setPrefHeight(50);
		Button open = new Button("Open existing...");
		open.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		open.setPrefHeight(50);
		VBox buttons = new VBox(startNew, open);
		VBox.setVgrow(open, Priority.ALWAYS);
		VBox.setVgrow(startNew, Priority.ALWAYS);
		Scene scene = new Scene(buttons);
*/
		// But for now, we'll just start a new design
		Editor e = new Editor();
		Scene scene = new Scene(e.getPresentation().getTopLevel());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
