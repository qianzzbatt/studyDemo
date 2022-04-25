package com.springbootdemo.study.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/23
 **/

@Component
public class XxlJobHandler {

    private static Logger logger = LoggerFactory.getLogger(XxlJobHandler.class);


    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("simpleJobHandler")
    public void simpleJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");
        System.out.println("1111111");
    }

}
