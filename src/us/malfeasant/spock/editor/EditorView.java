package us.malfeasant.spock.editor;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class EditorView {
	private final BorderPane topLevel;
	
	/**
	 *	Create the editor layout.  A design (new or loaded) to be added after construction.
	 */
	public EditorView() {
		topLevel = new BorderPane();
		// TODO: Make it go
	}
	
	public Parent getParent() {
		return topLevel;
	}
}
