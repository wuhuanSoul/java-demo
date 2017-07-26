package com.systec.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by wh on 7/19/2017.
 */
public class JobSchedule implements Job {

    public JobSchedule(){
        super();
    }
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("自定义项目组名和触发器名的定时任务");
    }
}
