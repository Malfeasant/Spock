package us.malfeasant.spock.ui;

import javafx.scene.layout.Pane;
import us.malfeasant.spock.Circuit;

/**
 * The visual representation of one circuit within another- this subclasses Pane so it can contain
 * multiple controls if needed.
 * @author Malfeasant
 */
public class CircuitIcon extends Pane {
	private final Circuit circ;
	
	public CircuitIcon(Circuit c) {
		assert(c != null) : "CircuitIcon must be initialized with a Circuit object.";
		circ = c;
	}
}
