package us.malfeasant.spock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Launcher extends Application {
	@Override
	public void start(Stage primaryStage) {
		Button startNew = new Button("New Design");
		startNew.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		startNew.setPrefHeight(50);
		Button open = new Button("Open existing...");
		open.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		open.setPrefHeight(50);
		VBox buttons = new VBox(startNew, open);
		VBox.setVgrow(open, Priority.ALWAYS);
		VBox.setVgrow(startNew, Priority.ALWAYS);
		Scene scene = new Scene(buttons);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
