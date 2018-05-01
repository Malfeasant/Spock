package us.malfeasant.spock.editor;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Editor {
	private final BorderPane topLevel;
	
	/**
	 *	Create the editor layout.  A design (new or loaded) to be added after construction.
	 */
	public Editor() {
		topLevel = new BorderPane();
		// TODO: Make it go
	}
	
	public Parent getParent() {
		return topLevel;
	}
}
