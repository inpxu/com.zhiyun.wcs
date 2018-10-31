/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 任务记录实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class TaskRecord extends BaseEntity<Long> {

    private static final long serialVersionUID = 4427474823808195474L;

    // ~~~~实体属性
    // 设备编码
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "设备编码字段过长")
    private String deviceNo;
    // 节点id
    @Max(value = 9223372036854775807L, message = "节点id字段过长")
    private Long siteId;
    // 到达时间
    private java.util.Date arriveTime;
    // 离开时间
    private java.util.Date leaveTime;
    // 企业id
    @Max(value = 9223372036854775807L, message = "企业id字段过长")
    private Long companyId;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    /**
     * 设备编码
     */
    public String getDeviceNo() {
        return this.deviceNo;
    }

    /**
     * 设备编码
     */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    /**
     * 节点id
     */
    public Long getSiteId() {
        return this.siteId;
    }

    /**
     * 节点id
     */
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * 到达时间
     */
    public java.util.Date getArriveTime() {
        return this.arriveTime;
    }

    /**
     * 到达时间
     */
    public void setArriveTime(java.util.Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    /**
     * 离开时间
     */
    public java.util.Date getLeaveTime() {
        return this.leaveTime;
    }

    /**
     * 离开时间
     */
    public void setLeaveTime(java.util.Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    /**
     * 企业id
     */
    @Override
    public Long getCompanyId() {
        return this.companyId;
    }

    /**
     * 企业id
     */
    @Override
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
