/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 物流设备定义实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class DeviceDefine extends BaseEntity<Long> {

    private static final long serialVersionUID = 6034039581449241677L;

    // ~~~~实体属性
    // 设备编码
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "设备编码字段过长")
    private String diviceNo;
    // 通讯方式
    @Pattern(regexp = "[\\s\\S]{0,10}", message = "通讯方式字段过长")
    private String communicationType;
    // IP地址
    @Pattern(regexp = "[\\s\\S]{0,20}", message = "IP地址字段过长")
    private String ip;
    // 机器猫编码
    @Max(value = 9223372036854775807L, message = "机器猫编码字段过长")
    private Long catNo;
    // 描述
    @Pattern(regexp = "[\\s\\S]{0,60}", message = "描述字段过长")
    private String deviceDesc;
    // mac地址
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "mac地址字段过长")
    private String macAddr;
    // 品牌
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "品牌字段过长")
    private String brand;
    // PLC型号
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "PLC型号字段过长")
    private String plc;
    // 出厂年月
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date ym;
    // 固件版本号
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "固件版本号字段过长")
    private String sfVersion;
    // 生产厂家
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "生产厂家字段过长")
    private String factory;
    // max_x
    @Max(value = 99999999999L, message = "max_x字段过长")
    private Integer maxX;
    // max_y
    @Max(value = 99999999999L, message = "max_y字段过长")
    private Integer maxY;
    // max_z
    @Max(value = 99999999999L, message = "max_z字段过长")
    private Integer maxZ;
    // 通讯协议
    @Max(value = 99999999999L, message = "通讯协议字段过长")
    private Integer protocolId;
    // 库区
    @Max(value = 99999999999L, message = "库区字段过长")
    private Integer storeAreaId;
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
    public String getDiviceNo() {
        return this.diviceNo;
    }

    /**
     * 设备编码
     */
    public void setDiviceNo(String diviceNo) {
        this.diviceNo = diviceNo;
    }

    /**
     * 通讯方式
     */
    public String getCommunicationType() {
        return this.communicationType;
    }

    /**
     * 通讯方式
     */
    public void setCommunicationType(String communicationType) {
        this.communicationType = communicationType;
    }

    /**
     * IP地址
     */
    public String getIp() {
        return this.ip;
    }

    /**
     * IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 机器猫编码
     */
    public Long getCatNo() {
        return this.catNo;
    }

    /**
     * 机器猫编码
     */
    public void setCatNo(Long catNo) {
        this.catNo = catNo;
    }

    /**
     * 描述
     */
    public String getDeviceDesc() {
        return this.deviceDesc;
    }

    /**
     * 描述
     */
    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
    }

    /**
     * mac地址
     */
    public String getMacAddr() {
        return this.macAddr;
    }

    /**
     * mac地址
     */
    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    /**
     * 品牌
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * PLC型号
     */
    public String getPlc() {
        return this.plc;
    }

    /**
     * PLC型号
     */
    public void setPlc(String plc) {
        this.plc = plc;
    }

    /**
     * 出厂年月
     */
    public java.util.Date getYm() {
        return this.ym;
    }

    /**
     * 出厂年月
     */
    public void setYm(java.util.Date ym) {
        this.ym = ym;
    }

    /**
     * 固件版本号
     */
    public String getSfVersion() {
        return this.sfVersion;
    }

    /**
     * 固件版本号
     */
    public void setSfVersion(String sfVersion) {
        this.sfVersion = sfVersion;
    }

    /**
     * 生产厂家
     */
    public String getFactory() {
        return this.factory;
    }

    /**
     * 生产厂家
     */
    public void setFactory(String factory) {
        this.factory = factory;
    }

    /**
     * max_x
     */
    public Integer getMaxX() {
        return this.maxX;
    }

    /**
     * max_x
     */
    public void setMaxX(Integer maxX) {
        this.maxX = maxX;
    }

    /**
     * max_y
     */
    public Integer getMaxY() {
        return this.maxY;
    }

    /**
     * max_y
     */
    public void setMaxY(Integer maxY) {
        this.maxY = maxY;
    }

    /**
     * max_z
     */
    public Integer getMaxZ() {
        return this.maxZ;
    }

    /**
     * max_z
     */
    public void setMaxZ(Integer maxZ) {
        this.maxZ = maxZ;
    }

    /**
     * 通讯协议
     */
    public Integer getProtocolId() {
        return this.protocolId;
    }

    /**
     * 通讯协议
     */
    public void setProtocolId(Integer protocolId) {
        this.protocolId = protocolId;
    }

    /**
     * 库区
     */
    public Integer getStoreAreaId() {
        return this.storeAreaId;
    }

    /**
     * 库区
     */
    public void setStoreAreaId(Integer storeAreaId) {
        this.storeAreaId = storeAreaId;
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
