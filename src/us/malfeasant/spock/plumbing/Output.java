package us.malfeasant.spock.plumbing;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Output {
	private MultiLogic value = MultiLogic.U;
	private List<LogicListener> listeners = new CopyOnWriteArrayList<>();	// Easy thread safety
	
	public MultiLogic get() {
		return value;
	}
	
	public void set(MultiLogic v) {
		value = v;
	}
	
	public void addListener(LogicListener l) {
		listeners.add(l);
	}
	
	public void removeListener(LogicListener l) {
		listeners.remove(l);
	}
}
