package com.zhiyun.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 13:54
 */
public class HistoryRecordDto implements Serializable {

    private static final long serialVersionUID = 4568869349668538869L;
    /**
     * 设备编码
     */
    private String deviceNo;
    /**
     * 单路径名
     */
    private String singlePathName;
    /**
     * 到达时间
     */
    private Date arriveTime;
    /**
     * 离开时间
     */
    private Date leaveTime;

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getSinglePathName() {
        return singlePathName;
    }

    public void setSinglePathName(String singlePathName) {
        this.singlePathName = singlePathName;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }
}
