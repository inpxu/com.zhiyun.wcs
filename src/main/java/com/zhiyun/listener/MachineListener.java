package com.zhiyun.listener;

import com.alibaba.fastjson.JSON;
import com.zhiyun.core.JobProcessEngine;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.util.WebSocketHolder;
import com.zhiyun.vo.SinglePathSetVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * 设备状态监听器
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-07 16:34
 */
public class MachineListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MachineListener.class);
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JobProcessEngine jobProcessEngine;

    //自定义监听器，没秒触发一次监听
    @Scheduled
    public void onMessage(String message) {
        Long taskId = 1L;
        Boolean status = true;
        if (status) {
            //任务已完成
            /**
             * 任务完成以后将完成后的任务从队列中移除
             *
             *
             */
            if (taskId == 1) {
                //任务执行完,删除之前执行的
                String o = (String) redisTemplate.boundListOps("jobQueue" + WebSocketHolder.getCompanyId()).leftPop();
                //只为获取企业id
                SystemTask systemTask1 = JSON.parseObject(o, SystemTask.class);

                //再获取一个执行
                List range = redisTemplate.boundListOps("jobQueue-" + systemTask1.getCompanyId()).range(0, -1);
                if (CollectionUtils.isNotEmpty(range)) {
                    SystemTask systemTask = JSON.parseObject((String) range.get(0), SystemTask.class);
                    //TODO 将新的任务下发给设备
                    List<SinglePathSetVo> singlePathSetVos = jobProcessEngine.shardingJob((String) range.get(0));

                }

            }

        }

    }

}
