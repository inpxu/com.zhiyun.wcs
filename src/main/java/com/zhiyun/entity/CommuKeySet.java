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
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommuKeySet extends BaseEntity<Long> {

    private static final long serialVersionUID = 1052476526814865704L;

    // ~~~~实体属性
    //
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "字段过长")
    private String macNo;
    //
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "字段过长")
    private String keyType;
    // 0产量/1其他参数
    @Max(value = 99999999999L, message = "0产量/1其他参数字段过长")
    private Integer isYield;
    // 0上行/1下行
    @Max(value = 99999999999L, message = "0上行/1下行字段过长")
    private Integer direction;
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
     *
     */
    public String getMacNo() {
        return this.macNo;
    }

    /**
     *
     */
    public void setMacNo(String macNo) {
        this.macNo = macNo;
    }

    /**
     *
     */
    public String getKeyType() {
        return this.keyType;
    }

    /**
     *
     */
    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    /**
     * 0产量/1其他参数
     */
    public Integer getIsYield() {
        return this.isYield;
    }

    /**
     * 0产量/1其他参数
     */
    public void setIsYield(Integer isYield) {
        this.isYield = isYield;
    }

    /**
     * 0上行/1下行
     */
    public Integer getDirection() {
        return this.direction;
    }

    /**
     * 0上行/1下行
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
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
