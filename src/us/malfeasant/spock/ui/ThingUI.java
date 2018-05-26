package us.malfeasant.spock.ui;

import javafx.scene.Node;
import us.malfeasant.spock.Thing;

/**
 *	@author Malfeasant
 *
 *	For lack of a better name...
 *	This will hold the graphical representation of a circuit component.  Maybe it should be an interface?  Maybe it should be
 *	abstract?  For now, just a plain old class.  Not all Things will have a ThingUI, but all ThingUIs will have a Thing.
 *	Also, ThingUIs can come and go, so Thing's reference to ThingUI is mutable, but not the reverse.
 */
public class ThingUI {
	private final Thing thing;	// The thing we belong to
	private Node node;	// the toplevel node representing the thing
	
	public ThingUI(Thing t) {
		if (t==null) throw new NullPointerException("ThingUI needs a Thing.");	// Throw NPE immediately
		thing = t;
	}
}
