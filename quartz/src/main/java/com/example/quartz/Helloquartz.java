package com.example.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Helloquartz implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("定时任务11111");

        JobDetail jobDetail =jobExecutionContext.getJobDetail();
        System.out.println(jobDetail.getJobDataMap().get("name"));
        System.out.println(jobDetail.getJobDataMap().get("age"));

    }

}
