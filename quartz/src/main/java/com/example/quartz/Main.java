package com.example.quartz;

import jakarta.ejb.Schedule;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) throws Exception {
       Scheduler scheduler=new StdSchedulerFactory().getScheduler();

//          任务
//        JobDetail job =JobBuilder.newJob().ofType(Helloquartz.class).build();

//        执行具体的调试类（调试任务）
        JobDetail job =JobBuilder.newJob().ofType(Helloquartz.class).usingJobData("name","liu").usingJobData("age","20").build();

        //调试时间配置
        Trigger trigger = TriggerBuilder.newTrigger().startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

        //加入调度 把任务与时间关联起来
        scheduler.scheduleJob(job,trigger);

        //启动
        scheduler.start();


    }
}
