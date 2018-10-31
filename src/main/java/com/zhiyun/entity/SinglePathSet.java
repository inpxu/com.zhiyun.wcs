/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 设备单路径设置实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SinglePathSet extends BaseEntity<Long> {

    private static final long serialVersionUID = 2333967073116727776L;

    // ~~~~实体属性
    // 设备编码
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "设备编码字段过长")
    private String macNo;
    // 路径号
    @Max(value = 99999999999L, message = "路径号字段过长")
    private Integer activeNo;
    // 路径名
    @Pattern(regexp = "[\\s\\S]{0,24}", message = "路径名字段过长")
    private String activeName;
    // 开始节点
    private Double startSiteId;
    // 结束节点
    private Double endSiteId;
    // 偏移量
    private Double offset;
    // 需要时间
    @Max(value = 99999999999L, message = "需要时间字段过长")
    private Integer needTime;
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
     * 路径号
     */
    public Integer getActiveNo() {
        return this.activeNo;
    }

    /**
     * 路径号
     */
    public void setActiveNo(Integer activeNo) {
        this.activeNo = activeNo;
    }

    /**
     * 路径名
     */
    public String getActiveName() {
        return this.activeName;
    }

    /**
     * 路径名
     */
    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    /**
     * 开始节点
     */
    public Double getStartSiteId() {
        return this.startSiteId;
    }

    /**
     * 开始节点
     */
    public void setStartSiteId(Double startSiteId) {
        this.startSiteId = startSiteId;
    }

    /**
     * 结束节点
     */
    public Double getEndSiteId() {
        return this.endSiteId;
    }

    /**
     * 结束节点
     */
    public void setEndSiteId(Double endSiteId) {
        this.endSiteId = endSiteId;
    }

    /**
     * 偏移量
     */
    public Double getOffset() {
        return this.offset;
    }

    /**
     * 偏移量
     */
    public void setOffset(Double offset) {
        this.offset = offset;
    }

    /**
     * 需要时间
     */
    public Integer getNeedTime() {
        return this.needTime;
    }

    /**
     * 需要时间
     */
    public void setNeedTime(Integer needTime) {
        this.needTime = needTime;
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
