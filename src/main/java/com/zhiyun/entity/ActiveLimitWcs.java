/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 动作条件限制实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class ActiveLimitWcs extends BaseEntity<Long> {

    private static final long serialVersionUID = 3900990664624924957L;

    // ~~~~实体属性
    // 设备编码
    private Long deviceId;
    // 动作号
    @Pattern(regexp = "[\\s\\S]{0,24}", message = "动作号字段过长")
    private String activeNo;
    // 先决设备
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "先决设备字段过长")
    private String limitMacNo;
    // 先决通讯键
    @Max(value = 9223372036854775807L, message = "先决通讯键字段过长")
    private String limitMem;
    // 先决通讯键值
    private String limitValue;
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
    public Long getdeviceId() {
        return this.deviceId;
    }

    /**
     * 设备编码
     */
    public void setdeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 动作号
     */
    public String getActiveNo() {
        return this.activeNo;
    }

    /**
     * 动作号
     */
    public void setActiveNo(String activeNo) {
        this.activeNo = activeNo;
    }

    /**
     * 先决设备
     */
    public String getLimitMacNo() {
        return this.limitMacNo;
    }

    /**
     * 先决设备
     */
    public void setLimitMacNo(String limitMacNo) {
        this.limitMacNo = limitMacNo;
    }

    /**
     * 先决通讯键
     */
    public String getLimitMem() {
        return this.limitMem;
    }

    /**
     * 先决通讯键
     */
    public void setLimitMem(String limitMem) {
        this.limitMem = limitMem;
    }

    /**
     * 先决通讯键值
     */
    public String getLimitValue() {
        return this.limitValue;
    }

    /**
     * 先决通讯键值
     */
    public void setLimitValue(String limitValue) {
        this.limitValue = limitValue;
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
