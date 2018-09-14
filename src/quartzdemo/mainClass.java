package quartzdemo;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class mainClass {

	public static void main(String[] args) {
		try {
			// Define Job detail
			JobDetail firstJobDetail = JobBuilder.newJob(PrintOutJob.class)
										.withIdentity("first job", "group 1")
										.build();
			// Define trigger
			Trigger firstTrigger = TriggerBuilder.newTrigger()
									.withIdentity("first trigger", "group 12")
									.withSchedule(SimpleScheduleBuilder.simpleSchedule()
																		.withIntervalInSeconds(3)
																		.repeatForever())
									.build();
			
			// schedule
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(firstJobDetail, firstTrigger);
			//scheduler.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
