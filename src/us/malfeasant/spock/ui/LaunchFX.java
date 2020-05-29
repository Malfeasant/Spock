package us.malfeasant.spock.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import us.malfeasant.spock.Circuit;

public class LaunchFX extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Parameters parms = getParameters();
		// TODO: parse command line args, look for file to open- for now just create a new one
		
		Circuit circ = new Circuit();
		CircuitLayout layout = new CircuitLayout(circ);
		
		new MainWindow(primaryStage, layout);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
