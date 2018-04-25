package us.malfeasant.spock.editor;

import us.malfeasant.spock.architecture.Control;

public class Editor extends Control {
	private final EditorPresentation pres;
	
	public Editor() {
		pres = new EditorPresentation();
	}
	
	public EditorPresentation getPresentation() {
		return pres;
	}
}
