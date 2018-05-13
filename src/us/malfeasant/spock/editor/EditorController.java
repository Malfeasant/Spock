package us.malfeasant.spock.editor;

public class EditorController {
	private final EditorModel model;
	private final EditorView view;
	
	private EditorController() {
		model = new EditorModel();
		view = new EditorView();
	}
	
	public static EditorController make() {
		return new EditorController();
	}
}
