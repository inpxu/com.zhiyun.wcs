package com.zhiyun.core;

import com.alibaba.fastjson.JSON;
import com.zhiyun.dto.JobInfoDto;
import com.zhiyun.dto.SinglePathInfoDto;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.entity.SystemTaskSingle;
import com.zhiyun.service.SystemTaskService;
import com.zhiyun.vo.SinglePathSetVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 任务核心类
 * 提供任务分解、队列控制
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 14:31
 */
@Slf4j
@Component
public class JobProcessEngine {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private SystemTaskService systemTaskService;
    @Autowired
    private JmsTemplate jmsQueueTemplate;

    /**
     * 默认等待队列长度为10
     */
    @Value("${waitingQueueSize:10}")
    private Integer waitingQueueSize;

    /**
     * 将任务添加到任务队列
     *
     * @param messageContent
     * @return void
     * @author 邓艺
     * @date 2018/9/12 11:05
     */
    public void addJobToQueue(String messageContent) {
        //消息转换
        if (StringUtils.isNotBlank(messageContent)) {
            SystemTask systemTask = JSON.parseObject(messageContent, SystemTask.class);
            //将数据队列缓存至redis
            redisTemplate.boundListOps("jobQueue-" + systemTask.getCompanyId()).rightPush(messageContent);
        }
    }

    /**
     * 任务自动拆分
     * 任务拆分只针对缓存队列中的任务,键为任务id
     *
     * @param jobContent json格式任务
     * @return void
     * @author 邓艺
     * @date 2018/9/19 14:52
     */
    public void autoShardingJob(String jobContent) {
        //将任务添加到任务队列
        addJobToQueue(jobContent);
        //将任务分解成单任务
        SystemTask systemTask = JSON.parseObject(jobContent, SystemTask.class);
        List<SinglePathSetVo> singlePathSets = systemTaskService.queryAllSinglePath(systemTask);
        //1.任务执行详情
        if (CollectionUtils.isNotEmpty(singlePathSets)) {
            BoundListOperations<String, String> listOperations = redisTemplate.boundListOps("jobInfo" + systemTask.getTaskId());
            for (int i = 0; i < singlePathSets.size(); i++) {
                JobInfoDto vo = new JobInfoDto();
                vo.setDestinationSiteName(singlePathSets.get(i).getDestinationSiteName());
                vo.setSerialNumber((long) i);
                vo.setDeviceNo(singlePathSets.get(i).getMacNo());
                if (i <= listOperations.size() - 1) {
                    vo.setPostJobNumber((long) (i + 1));
                }
                listOperations.rightPush(JSON.toJSONString(vo));
            }
            //2.任务路径信息
            List<SinglePathInfoDto> singlePathInfoDtos = systemTaskService.queryAllSinglePathInfo(systemTask);
            if (CollectionUtils.isNotEmpty(singlePathInfoDtos)) {
                BoundListOperations<String, String> singlePathInfoOps = redisTemplate.boundListOps("singlePathInfo" + systemTask.getTaskId());
                for (SinglePathInfoDto singlePathInfoDto : singlePathInfoDtos) {
                    singlePathInfoOps.rightPush(JSON.toJSONString(singlePathInfoDto));
                }
            }
        } else {
            //TODO 自动拆分任务失败以后是否提示解决？
            log.error("自动拆分任务失败");
        }

    }

    public List<SinglePathSetVo> shardingJob(String jobContent) {
        //将任务添加到任务队列
        SystemTask systemTask = JSON.parseObject(jobContent, SystemTask.class);
        List<SinglePathSetVo> singlePathSets = systemTaskService.queryAllSinglePath(systemTask);
        //1.任务执行详情
        if (CollectionUtils.isNotEmpty(singlePathSets)) {
            return singlePathSets;

        } else {
            //TODO 自动拆分任务失败以后是否提示解决？
            log.error("自动拆分任务失败");
        }

        return singlePathSets;
    }

    /**
     * 将由队列中的任务保存至数据库
     *
     * @param systemTask 任务对象
     * @return void
     * @author 邓艺
     * @date 2018/10/31 9:49
     */
    public void saveIntoDb(SystemTask systemTask) {
        systemTaskService.saveIntoDb(systemTask);

    }

    /**
     * 将任务下达给设备
     *
     * @param systemTaskSingles
     * @return void
     * @author 邓艺
     * @date 2018/10/31 15:51
     */
    public void sendMissionToDevice(List<SystemTaskSingle> systemTaskSingles) {
        if (CollectionUtils.isNotEmpty(systemTaskSingles)) {
            for (SystemTaskSingle systemTaskSingle : systemTaskSingles) {
//                jmsQueueTemplate.convertAndSend();
            }
        }
    }
}
