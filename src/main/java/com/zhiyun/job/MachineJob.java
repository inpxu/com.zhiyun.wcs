package com.zhiyun.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 设备任务类
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-12 14:06
 */
public class MachineJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(MachineJob.class);

    /**
     * 入库任务
     *
     * @param endSiteId
     * @param amount
     * @return void
     * @author 邓艺
     * @date 2018/9/10 11:10
     */
    private void importJob(Long endSiteId, Integer amount, Long companyId) {
        //TODO 获取起点
        Long start_site_id = 2L;
        moveJob(start_site_id, endSiteId, amount, companyId);
    }

    /**
     * 出库任务
     *
     * @param startSiteId
     * @param amount
     * @return void
     * @author 邓艺
     * @date 2018/9/10 11:10
     */
    private void exportJob(Long startSiteId, Integer amount, Long companyId) {
        //TODO 获取终点
        Long end_site_id = 2L;
        moveJob(startSiteId, end_site_id, amount, companyId);
    }

    /**
     * 搬运任务，所有的任务最终都是搬运任务
     *
     * @param startSiteId 起点
     * @param endSiteId 终点
     * @param amount 数量
     * @return void
     * @author 邓艺
     * @date 2018/9/7 15:33
     */
    private Boolean moveJob(Long startSiteId, Long endSiteId, Integer amount, Long companyId) {
        //从路径集中查询
        Map<String, Object> param = new HashMap<>(3);
        param.put("startSiteId", startSiteId);
        param.put("endSiteId", endSiteId);
        param.put("companyId", endSiteId);
        param.put("amount", amount);
        //向机器中发送控制命令
        return false;
    }

}
