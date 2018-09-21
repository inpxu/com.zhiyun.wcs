package com.zhiyun.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 14:10
 */
public class MachineNetWorkDto implements Serializable {

    private static final long serialVersionUID = -4829025410238467187L;
    private String catNo;
    private String deviceNo;
    private String communicationKey;
    private String communicationValue;
    private Date communicationTime;

    public String getCatNo() {
        return catNo;
    }

    public void setCatNo(String catNo) {
        this.catNo = catNo;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getCommunicationKey() {
        return communicationKey;
    }

    public void setCommunicationKey(String communicationKey) {
        this.communicationKey = communicationKey;
    }

    public String getCommunicationValue() {
        return communicationValue;
    }

    public void setCommunicationValue(String communicationValue) {
        this.communicationValue = communicationValue;
    }

    public Date getCommunicationTime() {
        return communicationTime;
    }

    public void setCommunicationTime(Date communicationTime) {
        this.communicationTime = communicationTime;
    }
}
