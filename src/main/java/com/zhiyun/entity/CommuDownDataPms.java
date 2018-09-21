/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 机联网下行数据实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class CommuDownDataPms extends BaseEntity<Long> {

    private static final long serialVersionUID = 1012089236271369208L;

    // ~~~~实体属性
    // 任务号
    @Max(value = 9223372036854775807L, message = "任务号字段过长")
    private Long taskId;
    // 机器猫编码
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "机器猫编码字段过长")
    private String catNo;
    // 设备编码
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "设备编码字段过长")
    private String macNo;
    // 通讯键
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "通讯键字段过长")
    private String communicationKey;
    // 键值
    private Double communicationValue;
    // 时间戳
    private java.util.Date communicationTime;
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
     * 任务号
     */
    public Long getTaskId() {
        return this.taskId;
    }

    /**
     * 任务号
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * 机器猫编码
     */
    public String getCatNo() {
        return this.catNo;
    }

    /**
     * 机器猫编码
     */
    public void setCatNo(String catNo) {
        this.catNo = catNo;
    }

    /**
     * 设备编码
     */
    public String getMacNo() {
        return this.macNo;
    }

    /**
     * 设备编码
     */
    public void setMacNo(String macNo) {
        this.macNo = macNo;
    }

    /**
     * 通讯键
     */
    public String getCommunicationKey() {
        return this.communicationKey;
    }

    /**
     * 通讯键
     */
    public void setCommunicationKey(String communicationKey) {
        this.communicationKey = communicationKey;
    }

    /**
     * 键值
     */
    public Double getCommunicationValue() {
        return this.communicationValue;
    }

    /**
     * 键值
     */
    public void setCommunicationValue(Double communicationValue) {
        this.communicationValue = communicationValue;
    }

    /**
     * 时间戳
     */
    public java.util.Date getCommunicationTime() {
        return this.communicationTime;
    }

    /**
     * 时间戳
     */
    public void setCommunicationTime(java.util.Date communicationTime) {
        this.communicationTime = communicationTime;
    }

    /**
     * 企业id
     */
    public Long getCompanyId() {
        return this.companyId;
    }

    /**
     * 企业id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
