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
 * 设备路径集实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PathCollectionsSet extends BaseEntity<Long> {

    private static final long serialVersionUID = 7796613781071450390L;

    // ~~~~实体属性
    // 设备编码
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "设备编码字段过长")
    private String deviceNo;
    // 路径名
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "路径名字段过长")
    private String pathName;
    // 结束节点
    @Max(value = 9223372036854775807L, message = "结束节点字段过长")
    private Long endtSiteId;
    // 开始节点
    @Max(value = 9223372036854775807L, message = "开始节点字段过长")
    private Long startSiteId;
    // 路径集
    private String pathGroup;
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
     * 路径名
     */
    public String getPathName() {
        return this.pathName;
    }

    /**
     * 路径名
     */
    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    /**
     * 结束节点
     */
    public Long getEndtSiteId() {
        return this.endtSiteId;
    }

    /**
     * 结束节点
     */
    public void setEndtSiteId(Long endtSiteId) {
        this.endtSiteId = endtSiteId;
    }

    /**
     * 开始节点
     */
    public Long getStartSiteId() {
        return this.startSiteId;
    }

    /**
     * 开始节点
     */
    public void setStartSiteId(Long startSiteId) {
        this.startSiteId = startSiteId;
    }

    /**
     * 路径集
     */
    public String getPathGroup() {
        return this.pathGroup;
    }

    /**
     * 路径集
     */
    public void setPathGroup(String pathGroup) {
        this.pathGroup = pathGroup;
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
