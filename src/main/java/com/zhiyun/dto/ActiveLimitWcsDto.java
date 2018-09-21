package com.zhiyun.dto;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 09:13
 */
public class ActiveLimitWcsDto implements Serializable {

    private static final long serialVersionUID = 6741337615785212099L;
    private String limitMacNo;
    private Long deviceId;
    private String limitMem;
    private String limitValue;

    public String getLimitMacNo() {
        return limitMacNo;
    }

    public void setLimitMacNo(String limitMacNo) {
        this.limitMacNo = limitMacNo;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getLimitMem() {
        return limitMem;
    }

    public void setLimitMem(String limitMem) {
        this.limitMem = limitMem;
    }

    public String getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(String limitValue) {
        this.limitValue = limitValue;
    }
}
