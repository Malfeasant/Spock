package us.malfeasant.spock.architecture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *	Parent of all Control classes: maintains a thread pool for async task execution
 *	@author Malfeasant
 */
public class Control {
	
	private static ExecutorService threadpool = Executors.newCachedThreadPool();
	
	
}
