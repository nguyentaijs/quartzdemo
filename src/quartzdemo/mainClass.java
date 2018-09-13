package quartzdemo;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class mainClass {

	public static void main(String[] args) {
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			scheduler.start();
			
			scheduler.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
