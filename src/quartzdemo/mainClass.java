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
										.usingJobData("JobDetailKey", "This is how you job detail transfer info")
										.build();
			// Define trigger
			Trigger firstTrigger = TriggerBuilder.newTrigger()
									.withIdentity("first trigger", "group 12")
									.usingJobData("TriggerKey", "This is also the way trigger transfer info")
									.withSchedule(SimpleScheduleBuilder.simpleSchedule()
																		.withIntervalInSeconds(9)
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
