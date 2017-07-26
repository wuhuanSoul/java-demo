package com.systec.quartz;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by wh on 7/18/2017.
 */
public class QuartzManager {

    private static String TASK_GROUP_NAME = "TASK_GROUP_NAME";
    private static String TRIGGER_GROUP_NAME = "TRIGGER_GROUP_NAME";

    /**
     * @describe 添加一个定时任务，使用默认的任务组和触发器组，且任务名与触发器名相同
     *
     * @param name 任务名（触发器名）
     * @param T     执行任务所在的类
     * @param time  任务调度执行方式（即调度时间形式）
     * @throws ParseException
     * @throws SchedulerException
     */

    public void addJob(String name, Class T, String time) throws ParseException, SchedulerException {
        addJob(name,TASK_GROUP_NAME, T, name, TRIGGER_GROUP_NAME, time);
    }

    /**
     * @describe 添加一个定时任务
     *
     * @param taskName  任务名
     * @param taskGroupName 任务组
     * @param T   执行任务所在的类
     * @param triggerName   触发器
     * @param triggerGroupName  触发器组
     * @param time  任务调度执行方式（即调度时间形式）
     * @throws SchedulerException
     * @throws ParseException
     */

    public void addJob(String taskName, String taskGroupName, Class T, String triggerName, String triggerGroupName,String time) throws SchedulerException, ParseException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetailImpl jobDetail = new JobDetailImpl(taskName, taskGroupName, T);
        CronTriggerImpl trigger = new CronTriggerImpl(triggerName, triggerGroupName);
        trigger.setCronExpression(time);
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * @ describe 修改定时任务调度时间方式，使用默认的任务组名和触发器组名，且任务名和触发器名。
     *
     * @param name 任务名（触发器名）
     * @param time  修改的时间
     * @throws SchedulerException
     * @throws ParseException
     */


    public void updateJobTime(String name, String time) throws SchedulerException, ParseException {
        System.out.println("进入修改时间方法：" + new Date(System.currentTimeMillis()));
        updateJobTime(name, "TRIGGER_GROUP_NAME", time);
    }

    /**
     * @describe 修改任务触发器的调度时间，
     *
     * @param triggerName   触发器名
     * @param triggerGroupName  触发器组
     * @param time 修改的时间
     * @throws SchedulerException
     * @throws ParseException
     */

    public void updateJobTime(String triggerName, String triggerGroupName, String time) throws SchedulerException, ParseException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroupName);
        CronTriggerImpl trigger = (CronTriggerImpl) scheduler.getTrigger(triggerKey);
        if (trigger == null){
            return;
        }
        if (!trigger.getCronExpression().equalsIgnoreCase(time)){
            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
            //按新的cronExpression表达式重新构建trigger
            CronTrigger cronTrigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
//            trigger.setCronExpression(time);
            scheduler.rescheduleJob(triggerKey, cronTrigger);
        }
    }

    /**
     * @describe 删除定时任务，任务组名和触发器组名为默认
     *
     * @param name
     * @throws SchedulerException
     */

    public void removeJob(String name) throws SchedulerException {
        removeJob(name, TASK_GROUP_NAME, name, TRIGGER_GROUP_NAME);
    }

    /**
     * @describe 删除定时任务，删除任务时，触发器也会被删除
     *
     * @param taskName 任务名
     * @param taskGroupName 任务组名
     * @throws SchedulerException
     */
    public void removeJob(String taskName, String taskGroupName, String triggerName, String triggerGroupName) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroupName);
        JobKey jobKey = new JobKey(taskName, taskGroupName);
        scheduler.pauseJob(jobKey);
        scheduler.unscheduleJob(triggerKey);
        scheduler.deleteJob(jobKey);
    }

    /**
     * @describe 开始定时任务，默认任务组名
     *
     * @param name 任务名
     * @throws SchedulerException
     */
    public void startJob(String name) throws SchedulerException {
        startJob(name, TASK_GROUP_NAME);
    }

    /**
     * @describe 开始定时任务
     *
     * @param taskName 任务名
     * @param taskGroupName 任务组名
     * @throws SchedulerException
     */
    public void startJob(String taskName, String taskGroupName) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.getJobDetail(new JobKey(taskName, taskGroupName));
        scheduler.start();
    }

    public static void main(String[] args) throws ParseException, SchedulerException {
        QuartzManager quartzManager = new QuartzManager();
        quartzManager.addJob("simpleSchedule",SimpleSchedule.class,"10/2 * * * * ?");
        quartzManager.startJob("simpleSchedule");
        Thread1 thread = new Thread1();
        thread.run();
    }

}
