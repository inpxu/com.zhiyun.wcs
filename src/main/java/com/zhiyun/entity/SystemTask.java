/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhiyun.base.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import java.util.Date;

/**
 * 系统任务表实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class SystemTask extends BaseEntity<Long> {

    private static final long serialVersionUID = 4832419110519878056L;

    // ~~~~实体属性
    // 库区id
    @Max(value = 9223372036854775807L, message = "库区id字段过长")
    private Long areaId;
    // 仓库id
    @Max(value = 9223372036854775807L, message = "仓库id字段过长")
    private Long storeId;
    // 起始节点id
    @Max(value = 9223372036854775807L, message = "起始节点id字段过长")
    private Long startSiteId;
    // 终止节点id
    @Max(value = 9223372036854775807L, message = "终止节点id字段过长")
    private Long endSiteId;
    // 进出库标记0进/1出
    @Max(value = 99999999999L, message = "进出库标记0进/1出字段过长")
    private Integer inMark;
    // 数量
    @Max(value = 99999999999L, message = "数量字段过长")
    private Integer amount;
    // 请求时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date requestTime;
    // 任务号
    @Max(value = 9223372036854775807L, message = "任务号字段过长")
    private Long taskId;
    // 企业id
    @Max(value = 9223372036854775807L, message = "企业id字段过长")
    private Long companyId;

    @Override
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return super.getCreateTime();
    }

    @Override
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getModifyTime() {
        return super.getModifyTime();
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    /**
     * 库区id
     */
    public Long getAreaId() {
        return this.areaId;
    }

    /**
     * 库区id
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * 仓库id
     */
    public Long getStoreId() {
        return this.storeId;
    }

    /**
     * 仓库id
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * 起始节点id
     */
    public Long getStartSiteId() {
        return this.startSiteId;
    }

    /**
     * 起始节点id
     */
    public void setStartSiteId(Long startSiteId) {
        this.startSiteId = startSiteId;
    }

    /**
     * 终止节点id
     */
    public Long getEndSiteId() {
        return this.endSiteId;
    }

    /**
     * 终止节点id
     */
    public void setEndSiteId(Long endSiteId) {
        this.endSiteId = endSiteId;
    }

    /**
     * 进出库标记0进/1出
     */
    public Integer getInMark() {
        return this.inMark;
    }

    /**
     * 进出库标记0进/1出
     */
    public void setInMark(Integer inMark) {
        this.inMark = inMark;
    }

    /**
     * 数量
     */
    public Integer getAmount() {
        return this.amount;
    }

    /**
     * 数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 请求时间
     */
    public java.util.Date getRequestTime() {
        return this.requestTime;
    }

    /**
     * 请求时间
     */
    public void setRequestTime(java.util.Date requestTime) {
        this.requestTime = requestTime;
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
