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
 * 设备动作设置实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MotionSet extends BaseEntity<Long> {

    private static final long serialVersionUID = 1046893927732757575L;

    // ~~~~实体属性
    // 设备编码
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "设备编码字段过长")
    private String macNo;
    // 动作号
    @Max(value = 99999999999L, message = "动作号字段过长")
    private Integer activeNo;
    // 动作名
    @Pattern(regexp = "[\\s\\S]{0,24}", message = "动作名字段过长")
    private String activeName;
    // 顺序号
    @Max(value = 99999999999L, message = "顺序号字段过长")
    private Integer serial;
    // x
    private Double x;
    // y
    private Double y;
    // z
    private Double z;
    // 偏移量
    private Double skewing;
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
     * 动作号
     */
    public Integer getActiveNo() {
        return this.activeNo;
    }

    /**
     * 动作号
     */
    public void setActiveNo(Integer activeNo) {
        this.activeNo = activeNo;
    }

    /**
     * 动作名
     */
    public String getActiveName() {
        return this.activeName;
    }

    /**
     * 动作名
     */
    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    /**
     * 顺序号
     */
    public Integer getSerial() {
        return this.serial;
    }

    /**
     * 顺序号
     */
    public void setSerial(Integer serial) {
        this.serial = serial;
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
     * 偏移量
     */
    public Double getSkewing() {
        return this.skewing;
    }

    /**
     * 偏移量
     */
    public void setSkewing(Double skewing) {
        this.skewing = skewing;
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
