package com.zhiyun.test;

import com.zhiyun.client.UserHolder;
import com.zhiyun.internal.wcs.SitSet;
import com.zhiyun.internal.wcs.WcsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-07 16:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class WcsTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private WcsService wcsService;

    @Test
    public void demo1() {
        BoundListOperations<String, String> demoKey = redisTemplate.boundListOps("demoKey");
        for (int i = 0; i < 5; i++) {
            demoKey.rightPush(String.valueOf(i));
        }
    }

    @Test
    public void demo4() {
        redisTemplate.boundListOps("demoKey").rightPush("44");
    }

    @Test
    public void demo2() {
        String demoKey = redisTemplate.boundListOps("demoKey").leftPop();
        System.out.println(demoKey);
    }

    @Test
    public void demo3() {
        List<String> demoKey = redisTemplate.boundListOps("demoKey").range(0L, -1L);
        System.err.println(demoKey);
    }

    @Test
    public void demo5() {
        BoundListOperations<String, String> demoKey = redisTemplate.boundListOps("demoKey");

        for (int i = 0; i < 6; i++) {
            String s = demoKey.leftPop();
            System.err.println(s);
        }

    }

    @Test
    public void demo6() {
        //没有队列是将为null
        BoundListOperations<String, String> waitQueueOp = redisTemplate.boundListOps("waitingQueue" + UserHolder.getCompanyId());
        System.out.println(waitQueueOp.size());
    }

    @Test
    public void demo7() {
        SitSet sitSet = wcsService.queryDetailById(38L, 1L);
        System.err.println(sitSet);
    }

    @Test
    public void demo8() {
        List<Long> list = new ArrayList<>();
        list.add(38L);
        list.add(40L);
        list.add(39L);
        list.add(42L);
        list.add(41L);
        List<SitSet> allSitesNotInIds = wcsService.getAllSitesNotInIds(1L, list);
        System.out.println(allSitesNotInIds);
    }




}
