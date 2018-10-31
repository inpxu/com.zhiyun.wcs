/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 设备节点设置实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class SitSet extends BaseEntity<Long> {

    private static final long serialVersionUID = 7509146345876942897L;

    // ~~~~实体属性
    // 设备编码
    @Pattern(regexp = "[\\S]{0,30}", message = "设备编码字段过长")
    private String macNo;
    // 生产设备编码
    @Pattern(regexp = "[\\S]{0,30}", message = "生产设备编码字段过长")
    private String prodMacNo;
    // 节点名
    @Pattern(regexp = "[\\S]{0,24}", message = "节点名字段过长")
    private String siteName;
    // z
    private Double z;
    // y
    private Double y;
    // x
    private Double x;
    // 偏移量
    private Double offset;
    // 节点类型节点0,上料1,下料2
    @Max(value = 99999999999L, message = "节点类型节点0,上料1,下料2字段过长")
    private Integer siteType;
    // 层数
    @Max(value = 99999999999L, message = "层数字段过长")
    private Integer layer;
    // 设备内置节点编码
    @Pattern(regexp = "[\\S]{0,20}", message = "设备内置节点编码字段过长")
    private String macInSiteNo;
    // 物料信息
    @Pattern(regexp = "[\\S]{0,30}", message = "物料信息字段过长")
    private String matterName;
    // 后置时间
    private java.util.Date afterTime;
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
     * 生产设备编码
     */
    public String getProdMacNo() {
        return this.prodMacNo;
    }

    /**
     * 生产设备编码
     */
    public void setProdMacNo(String prodMacNo) {
        this.prodMacNo = prodMacNo;
    }

    /**
     * 节点名
     */
    public String getSiteName() {
        return this.siteName;
    }

    /**
     * 节点名
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * z
     */
    public Double getZ() {
        return this.z;
    }

    /**
     * z
     */
    public void setZ(Double z) {
        this.z = z;
    }

    /**
     * y
     */
    public Double getY() {
        return this.y;
    }

    /**
     * y
     */
    public void setY(Double y) {
        this.y = y;
    }

    /**
     * x
     */
    public Double getX() {
        return this.x;
    }

    /**
     * x
     */
    public void setX(Double x) {
        this.x = x;
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
     * 节点类型节点0,上料1,下料2
     */
    public Integer getSiteType() {
        return this.siteType;
    }

    /**
     * 节点类型节点0,上料1,下料2
     */
    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

    /**
     * 层数
     */
    public Integer getLayer() {
        return this.layer;
    }

    /**
     * 层数
     */
    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    /**
     * 设备内置节点编码
     */
    public String getMacInSiteNo() {
        return this.macInSiteNo;
    }

    /**
     * 设备内置节点编码
     */
    public void setMacInSiteNo(String macInSiteNo) {
        this.macInSiteNo = macInSiteNo;
    }

    /**
     * 物料信息
     */
    public String getMatterName() {
        return this.matterName;
    }

    /**
     * 物料信息
     */
    public void setMatterName(String matterName) {
        this.matterName = matterName;
    }

    /**
     * 后置时间
     */
    public java.util.Date getAfterTime() {
        return this.afterTime;
    }

    /**
     * 后置时间
     */
    public void setAfterTime(java.util.Date afterTime) {
        this.afterTime = afterTime;
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
