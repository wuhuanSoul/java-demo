package com.systec.quartz;

import org.quartz.SchedulerException;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by wh on 7/19/2017.
 */
public class Thread1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("线程执行时间：" + new Date(System.currentTimeMillis()));
            QuartzManager quartzManager = new QuartzManager();
            quartzManager.updateJobTime("simpleSchedule", "*/10 * * * * ?");
//            quartzManager.removeJob("simpleSchedule");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
