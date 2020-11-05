package com.cloud.api.config.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/3 22:16
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail deployJob() {
        return JobBuilder.newJob(AnalyzeUserData.class).withIdentity("analyze").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger1() {
        //5天执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInHours(24 * 5)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(deployJob())
                .withIdentity("analyze")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
