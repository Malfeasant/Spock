package us.malfeasant.spock.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class LaunchFX extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		// TODO: parse command line args, look for file to open- for now just start a new one
		
		new MainWindow(primaryStage, null);	// TODO: replace with an empty design
	}

	public static void main(String[] args) {
		launch(args);
	}
}
