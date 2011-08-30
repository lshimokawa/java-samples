package net.lshimokawa.ejemplos.springquartz;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * @author lshimokawa
 * 
 */
public class HelloWorldJob extends QuartzJobBean {
	private final Logger logger = Logger.getLogger(HelloWorldJob.class);

	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		logger.debug("Hello World con QuartzJobBean");
	}
}