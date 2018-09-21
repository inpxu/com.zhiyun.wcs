package com.zhiyun.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhiyun.dto.InitialDto;
import com.zhiyun.dto.RunningTaskDto;
import com.zhiyun.dto.WaittingTaskDto;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.util.WebSocketHolder;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化推送业务实现类
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 15:26
 */
@Component
public class InitialService {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitialService.class);
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Value("${waitingQueueSize:10}")
    private Integer waitingQueueSize;

    public String firstPush() {
        InitialDto initialDto = new InitialDto();
        BoundListOperations<String, String> jobQueueOps = redisTemplate.boundListOps("jobQueue-" + WebSocketHolder.getCompanyId());

        //如果redis中未存在
        if (CollectionUtils.isNotEmpty(jobQueueOps.range(0, -1))) {
            /**
             * 1.获取正在执行任务和待执行任务队列
             */
            RunningTaskDto runningTaskDto = new RunningTaskDto();
            List<String> range = jobQueueOps.range(0, 1);
            runningTaskDto.setRunningTask(JSON.parseObject(range.get(0)));
            SystemTask systemTask = JSON.parseObject(range.get(0), SystemTask.class);
            List<String> range1 = redisTemplate.boundListOps("jobInfo" + systemTask.getTaskId()).range(0, -1);
            if (CollectionUtils.isNotEmpty(range1)) {
                runningTaskDto.setJobInfo(parsing2jsonobject(range1));
            }
            List<String> range2 = redisTemplate.boundListOps("singlePathInfo" + systemTask.getTaskId()).range(0, -1);
            if (CollectionUtils.isNotEmpty(range2)) {
                runningTaskDto.setSinglePathInfo(parsing2jsonobject(range2));
            }
            initialDto.setRunningTask(runningTaskDto);
            /**
             * 查询待运行任务队列
             */
            List<String> wating = jobQueueOps.range(1, 1 + waitingQueueSize);
            if (CollectionUtils.isNotEmpty(wating)) {
                for (String s : wating) {
                    WaittingTaskDto waittingTaskDto = new WaittingTaskDto();
                    waittingTaskDto.setWaittingTask(JSON.parseObject(s));
                    SystemTask waitting = JSON.parseObject(s, SystemTask.class);
                    List<String> range3 = redisTemplate.boundListOps("jobInfo" + waitting.getTaskId()).range(0, -1);
                    if (CollectionUtils.isNotEmpty(range3)) {
                        waittingTaskDto.setJobInfo(parsing2jsonobject(range3));
                    }
                    List<String> range4 = redisTemplate.boundListOps("singlePathInfo" + waitting.getTaskId()).range(0, -1);
                    if (CollectionUtils.isNotEmpty(range4)) {
                        waittingTaskDto.setSinglePathInfo(parsing2jsonobject(range4));
                    }
                }

            }
        }
        return JSON.toJSONString(initialDto);
    }

    private List<JSONObject> parsing2jsonobject(List<String> range1) {
        if (CollectionUtils.isNotEmpty(range1)) {
            List<JSONObject> list = new ArrayList<>();
            for (int i = 0; i < range1.size(); i++) {
                String s = range1.get(i);
                list.set(i, JSON.parseObject(s));
            }
            return list;
        } else {
            return null;
        }

    }

}
