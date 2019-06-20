package us.malfeasant.spock;

import us.malfeasant.spock.ui.CircuitIcon;
import us.malfeasant.spock.ui.CircuitLayout;

/**
 * The container that holds all the bits of a circuit: its behavior, an icon for including within other layouts, its own layout
 * Only the behavior is required, for example icon will not exist for a toplevel object, 
 * layout will only exist for compound components.  
 * 
 * @author Malfeasant
 */
public class Circuit {
	private final CircuitBehavior behavior;
	private CircuitIcon icon;	// TODO: replace with interface to decouple from UI
	private CircuitLayout layout;	// TODO: replace with interface to decouple from UI
	
	public Circuit() {
		behavior = CircuitBehavior.create();
	}
}
