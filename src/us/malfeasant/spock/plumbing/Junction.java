package us.malfeasant.spock.plumbing;

import java.util.HashMap;
import java.util.Map;

public class Junction implements LogicListener {
	private final Map<Output, MultiLogic> outputs = new HashMap<>();
	private MultiLogic result = null;
	
	@Override
	public void update(Output source, MultiLogic value) {
		if (!value.equals(outputs.put(source, value))) {	// put returns previous mapping- only invalidate if it's different from new value
			invalidate();	// signify value has changed
		}	// else input didn't change
	}
	
	private void resolve() {
		MultiLogic result = outputs.isEmpty() ? MultiLogic.U : MultiLogic.Z;
		for (MultiLogic l : outputs.values()) {
			result = l.resolve(result);
		}
		this.result = result;
	}
	
	public MultiLogic get() {
		if (result == null) {
			resolve();
		}
		return result;
	}
	
	public void connect(Output o) {
		outputs.put(o, o.get());
		o.addListener(this);
		invalidate();
	}
	
	private void invalidate() {
		result = null;
	}
	
	/**
	 *	Override to be notified when one of the inputs has changed
	 */
	protected void invalidated() {}
}
