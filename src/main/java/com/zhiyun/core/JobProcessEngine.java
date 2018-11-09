package com.zhiyun.core;

import com.alibaba.fastjson.JSON;
import com.flame.ProductDispose;
import com.zhiyun.core.service.CarService;
import com.zhiyun.core.util.SiteUtil;
import com.zhiyun.dao.SitSetDao;
import com.zhiyun.dto.JobInfoDto;
import com.zhiyun.dto.SinglePathInfoDto;
import com.zhiyun.entity.SitSet;
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
    private SitSetDao sitSetDao;
    @Autowired
    private CarService carService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private SystemTaskService systemTaskService;
    @Autowired
    private ProductDispose productDispose;
    private Boolean status = true;

    /**
     * 默认等待队列长度为10
     */
    @Value("${waitingQueueSize:10}")
    private Integer waitingQueueSize;
    //虚假的执行时间
    @Value("${fakeTime:1}")
    private Long fakeTime;

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
                //实现流程从6号上料为将物料存至立体库，然后从立体库将料运送至传送带202,然后通过传送带将物料运送至301
                try {
                    //1.第一条命令 去21拿空箱   01010301 0C 00 00 00 00 00 06 01 10 000100020400020001
                    //                       010103011100000000000b01100001000204000200010000
                    String com = "0167180010";
                    String oderOne = "01010301 11 00 00 00 00 00 0B 01 10 00 01 00 02 04 00 02 00 6e 0000";
                    //                01010301 11 00 00 00 00 00 0b 01 10 00 01 00 02 04 00 02 00 01 0000
                    productDispose.sendToMachine(com, oderOne);
                    Thread.sleep(60000);
                    String oderTwo = "01010301 0C 00 00 00 00 00 60 10 60 00 00 10 00000";
                    productDispose.sendToMachine(com, oderTwo);
                    Thread.sleep((fakeTime * 60 * 1000));

                    //监听执行状态
                    //if (status) {
                    //    String oderFoure = "010103010C000000000006010600000C000000";
                    //    productDispose.sendToMachine(com, oderFoure);
                    //}
                    //
                    //2.拿空箱
                    //                    String oderThree = "010103010C0000000000060106000002000000";
                    //                    productDispose.sendToMachine(com, oderThree);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                    //                    //2.走到6
                    //                    String oderFour = "010103011100000000000B01100001000204000000060000";
                    //                    productDispose.sendToMachine(com, oderFour);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                    String oderFive = "010103010C 00 00 00 00 00 06 01 06000000890000";
                    //                    productDispose.sendToMachine(com, oderFive);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                    //                    //3.取有物料的箱子 010103010C 00000000000601 06 0000 008A
                    //                    String oderSix = "01010301 0C 00000000000601 0600 00008A 0000";
                    //                    productDispose.sendToMachine(com, oderSix);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                    //                    //4.放空箱 010103010C 00000000000601 10 0001 0002 04 00000006
                    //                    String oderSeven = "010103011100000000000B01100001000204000000060000";
                    //                    productDispose.sendToMachine(com, oderSeven);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                    //                    String oderEight = "010103010C0000000000060106000081000000";
                    //                    productDispose.sendToMachine(com, oderEight);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                    //                    String oderNine = "010103010C0000000000060106000084000000";
                    //                    productDispose.sendToMachine(com, oderNine);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                    //                    //5.将有货的箱子运到之前拿箱子的位置
                    //                    String oderTen = "01010301    11 00000000000B01 10 0001000204000300040000";
                    //                    productDispose.sendToMachine(com, oderTen);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                    //                    String oderEleven = "01010301 0C 00000000000601 0600 000900 0000";
                    //                                         01010301 0d 00000000000701 060600 00009 00000
                    //                    productDispose.sendToMachine(com, oderEleven);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                    //                    String oderTwelve = "01010301 0C 00000000000601 06 00 00 0C 00 0000";
                    //                    productDispose.sendToMachine(com, oderTwelve);
                    //                    Thread.sleep((fakeTime * 60 * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 执行搬运任务
     *
     * @param startSiteId
     * @param endSiteId
     * @return void
     * @author 邓艺
     * @date 2018/11/9 10:03
     */
    public void excuteJob(Long startSiteId, Long endSiteId) {
        //设备机联网编码
        String mcatNo = null;
        //1.判断是否间隔
        SitSet startSit = sitSetDao.get(startSiteId);
        SitSet endSit = sitSetDao.get(endSiteId);
        //中间没有间隔
        if (Math.abs(SiteUtil.columnNumber(startSit.getSiteName()) - SiteUtil.columnNumber(endSit.getSiteName())) == 1) {
            //判断起点是否在立库上
            if (SiteUtil.columnNumber(startSit.getSiteName()) == 1 || SiteUtil.columnNumber(startSit.getSiteName()) == 6) {
                //使用终点堆垛机
                mcatNo = endSit.getMacNo();
            } else {
                //使用起点堆垛机
                mcatNo = startSit.getMacNo();
            }
            //1.叫车，叫车之后要监控命令是否下发成功
            if (carService.callACar(startSit,mcatNo)) {
                //2.到目的地后，目的地叫车
                if (carService.driveToDestination(endSit,mcatNo)) {
                    //到达目的地
                }
            }
        } else {
            //中间有间隔
            if (SiteUtil.columnNumber(startSit.getSiteName()) < SiteUtil.columnNumber(endSit.getSiteName())) {
                //3=>6

            } else {
                //6=>1

            }
        }
    }
}
