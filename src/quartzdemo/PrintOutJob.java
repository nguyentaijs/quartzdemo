package quartzdemo;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class PrintOutJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey key = context.getJobDetail().getKey();
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		String jobDetailValueStr = jobDataMap.getString("JobDetailKey");
		String triggerValueStr = jobDataMap.getString("TriggerKey");
		String format = "%-30s|%-30s\n";
		System.out.format(format, "Key", key);
		System.out.format(format, "Job detail value", jobDetailValueStr);
		System.out.format(format, "Trigger value", triggerValueStr);
	}

	
}
