package com.cloud.api.config.quartz;

import com.cloud.api.mapper.UserMapper;
import com.cloud.api.util.SpringUtil;

import com.cloud.api.util.algorithm.AnalyzeUserData;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 需求：不断的往前推一周，然后返回正负结果数据
 * <p>
 * 分析用户图片然后保存文件到静态目录
 * 需要获取到每一个用户他发布的图片
 * 注释的内容都是处理任务的代码
 *
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/11/3 22:18
 */
@SuppressWarnings("all")
public class CronJob extends QuartzJobBean {

    private UserMapper userMapper = (UserMapper) SpringUtil.getBean("userMapper");

    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        analyzeUserData();
    }

    /**
     * 处理事务的方法，这里使用异步操作，放置分析用户数据的方法
     * 分析然后写出json文件
     */
    @Async
    private void analyzeUserData(){
        AnalyzeUserData.analyze();
    }

}

