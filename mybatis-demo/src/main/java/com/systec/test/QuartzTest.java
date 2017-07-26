package com.systec.test;

import com.systec.quartz.SimpleSchedule;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by wh on 7/19/2017.
 */
public class QuartzTest {
    public static void task() throws SchedulerException, ParseException {
        //通过SchedulerFactory来创建一个调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetailImpl jobDetail1 = new JobDetailImpl("jobDetail1","jobGroup",SimpleSchedule.class);
        CronTriggerImpl trigger = new CronTriggerImpl("trigger1","triggerGroup");
        long ctime = System.currentTimeMillis();
        trigger.setStartTime(new Date(ctime));
        trigger.setEndTime(new Date(ctime + 10000));
        trigger.setCronExpression("*/2 * * * * ?");
        scheduler.scheduleJob(jobDetail1,trigger);
        scheduler.start();
    }

    public static void main(String[] args) {
        try {
            QuartzTest.task();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
