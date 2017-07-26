package com.systec.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;

import java.util.Date;

/**
 * Created by wh on 7/18/2017.
 */
public class SimpleSchedule implements Job {

    public SimpleSchedule(){

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(new Date(System.currentTimeMillis()));
        Scheduler scheduler = context.getScheduler();
        System.out.println("执行任务调度的job!");
    }
}
