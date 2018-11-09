package com.zhiyun.core.service;

import com.flame.ProductDispose;
import com.zhiyun.core.util.ListenUtil;
import com.zhiyun.core.util.MessageUtil;
import com.zhiyun.entity.SitSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-11-08 11:10
 */
@Slf4j
@Component
public class CarService {
    @Autowired
    private ProductDispose productDispose;
    @Value("${getBoxOverTime:1}")
    private Integer getBoxOverTime;
    @Value("${writeRegisterOverTime:1}")
    private Integer writeRegisterOverTime;
    @Value("${putBoxOverTime:1}")
    private Integer putBoxOverTime;
    @Value("${moveOverTime:1}")
    private Integer moveOverTime;
    private Long startTimeMillis;

    /**
     * 叫车
     * 叫车功能为，到达目的地，然后将箱子拿起来
     *
     * @param sitSet 节点
     * @param mcatNo
     * @return void
     * @author 邓艺
     * @date 2018/11/8 11:19
     */
    public Boolean callACar(SitSet sitSet, String mcatNo) {
        //生成报文
        String order = MessageUtil.generateMessageContentForPositionSet(sitSet.getSiteName());
        String positionSetOrder = MessageUtil.message4ManyRegister(order);
        //发送报文
        productDispose.sendToMachine(sitSet.getMacNo(), positionSetOrder);
        startTimeMillis = System.currentTimeMillis();
        //进入死循环，直到相应成功
        while (true) {
            //判断
            if (ListenUtil.setPositionIsOk()) {
                return toDestination(sitSet);
            } else {
                //超时以后，要件命令重新发送
                if ((System.currentTimeMillis() - startTimeMillis) >= (writeRegisterOverTime * 1000)) {
                    callACar(sitSet, mcatNo);
                }
            }

        }

    }

    /**
     * 行走至目的地并取箱子
     *
     * @param sitSet 目的地
     * @return java.lang.Boolean
     * @author 邓艺
     * @date 2018/11/9 15:45
     */
    private Boolean toDestination(SitSet sitSet) {
        //命令车行走
        String moveOrder = MessageUtil.generateMessageContentForMotionSet(sitSet, 1, 0, 0, 1);
        //发送报文
        productDispose.sendToMachine(sitSet.getMacNo(), moveOrder);
        startTimeMillis = System.currentTimeMillis();
        while (true) {
            if (ListenUtil.moveIsOk()) {
                return getBox(sitSet);
            } else {
                //超时以后，要件命令重新发送
                if ((System.currentTimeMillis() - startTimeMillis) >= (moveOverTime * 1000)) {
                    toDestination(sitSet);
                }
            }
        }
    }

    /**
     * 取箱子
     *
     * @param sitSet
     * @return java.lang.Boolean
     * @author 邓艺
     * @date 2018/11/9 15:54
     */
    private Boolean getBox(SitSet sitSet) {
        //取箱子
        String getBoxOrder = MessageUtil.generateMessageContentForMotionSet(sitSet, 1, 0, 1, 0);
        //发送报文
        productDispose.sendToMachine(sitSet.getMacNo(), getBoxOrder);
        startTimeMillis = System.currentTimeMillis();
        while (true) {
            if (ListenUtil.getBoxIsOk()) {
                return true;
            } else {
                //超时以后，要件命令重新发送
                if ((System.currentTimeMillis() - startTimeMillis) >= (getBoxOverTime * 1000)) {
                    getBox(sitSet);
                }
            }
        }
    }

    /**
     * 到目的地
     *
     * @param sitSet 目的地
     * @param mcatNo
     * @return java.lang.Boolean
     * @author 邓艺
     * @date 2018/11/9 15:17
     */
    public Boolean driveToDestination(SitSet sitSet, String mcatNo) {
        //生成报文
        String order = MessageUtil.generateMessageContentForPositionSet(sitSet.getSiteName());
        String positionSetOrder = MessageUtil.message4ManyRegister(order);
        //发送报文
        productDispose.sendToMachine(sitSet.getMacNo(), positionSetOrder);
        startTimeMillis = System.currentTimeMillis();
        //进入死循环，直到相应成功
        while (true) {
            //判断
            if (ListenUtil.setPositionIsOk()) {
                return getaBoolean(sitSet);
            } else {
                if ((System.currentTimeMillis() - startTimeMillis) >= (writeRegisterOverTime * 1000)) {
                    driveToDestination(sitSet, mcatNo);
                }
            }
        }
    }

    private Boolean getaBoolean(SitSet sitSet) {
        //命令车行走
        String moveOrder = MessageUtil.generateMessageContentForMotionSet(sitSet, 1, 0, 0, 1);
        //发送报文
        productDispose.sendToMachine(sitSet.getMacNo(), moveOrder);
        startTimeMillis = System.currentTimeMillis();
        while (true) {
            if (ListenUtil.moveIsOk()) {
                return putBox(sitSet);
            } else {
                //超时以后，要件命令重新发送
                if ((System.currentTimeMillis() - startTimeMillis) >= (moveOverTime * 1000)) {
                    getaBoolean(sitSet);
                }
            }
        }
    }

    private Boolean putBox(SitSet sitSet) {
        //放箱子
        String getBoxOrder = MessageUtil.generateMessageContentForMotionSet(sitSet, 1, 1, 0, 0);
        //发送报文
        productDispose.sendToMachine(sitSet.getMacNo(), getBoxOrder);
        startTimeMillis = System.currentTimeMillis();
        while (true) {
            if (ListenUtil.getBoxIsOk()) {
                return true;
            } else {
                //超时以后，要件命令重新发送
                if ((System.currentTimeMillis() - startTimeMillis) >= (putBoxOverTime * 1000)) {
                    putBox(sitSet);
                }
            }
        }
    }
}
