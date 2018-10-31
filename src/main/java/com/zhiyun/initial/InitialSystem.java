package com.zhiyun.initial;

import com.zhiyun.entity.SitSet;
import com.zhiyun.internal.uniqueid.UniqueIdService;
import com.zhiyun.service.SitSetService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 18:13
 */
@Component
public class InitialSystem {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitialSystem.class);
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UniqueIdService uniqueIdService;
    @Autowired
    private SitSetService sitSetService;

    /**
     * 项目启动时自动获取第一个任务开始执行
     *
     * @param
     * @return void
     * @author 邓艺
     * @date 2018/9/19 18:15
     */
    //    @PostConstruct
    public void initial() {
        List<SitSet> list = sitSetService.queryAllCompany();
        if (CollectionUtils.isNotEmpty(list)) {
            for (SitSet sitSet : list) {
                List<String> range = redisTemplate.boundListOps("jobQueue-" + sitSet.getCompanyId()).range(0, 1);
                if (CollectionUtils.isNotEmpty(range)) {
                    //TODO 将任务下达设备
                    //                    new Thread(new Runnable() {
                    //                        @Override
                    //                        public void run() {
                    //
                    //                        }
                    //                    }).start();
                } else {
                    LOGGER.warn("任务redis队列中还未存在任务");
                }
            }
        }
    }

}
