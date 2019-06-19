package us.malfeasant.spock;

/**
 * A behavioral model of a circuit.  Can have any combination of inputs, outputs, and bidirectional connections.
 * Separate from any UI representation.  
 * @author Malfeasant
 */
public class CircuitBehavior {
	
	public static CircuitBehavior create() {
		return new CircuitBehavior();
	}
}
