package demo.minifly.com.newandroidframe.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {
	
	static ExecutorService cachedThreadPool = null;
	
	public static void newThread(Runnable runnable) {
		
		if (cachedThreadPool == null) {
			cachedThreadPool = Executors.newCachedThreadPool();
		}
		cachedThreadPool.execute(runnable);
	}
}
