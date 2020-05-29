package us.malfeasant.spock.ui;

import javafx.scene.layout.Pane;
import us.malfeasant.spock.Circuit;

public class CircuitLayout extends Pane {
	private final Circuit circ;
	
	public CircuitLayout(Circuit c) {
		assert (c!=null) : "CircuitLayout must be initialized with a Circuit object.";
		circ = c;
		
		// TODO: some setup
	}
}
