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
public class CommuKeyvalueSet extends BaseEntity<Long> {

    private static final long serialVersionUID = 5598568318672690004L;

    // ~~~~实体属性
    // 关联id
    @Max(value = 9223372036854775807L, message = "关联id字段过长")
    private Long keyId;
    // 值
    private Double keyValue;
    // 描述
    @Pattern(regexp = "[\\s\\S]{0,20}", message = "描述字段过长")
    private String keyDesc;
    //
    @Pattern(regexp = "[\\s\\S]{0,40}", message = "字段过长")
    private String remark;
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
     * 关联id
     */
    public Long getKeyId() {
        return this.keyId;
    }

    /**
     * 关联id
     */
    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    /**
     * 值
     */
    public Double getKeyValue() {
        return this.keyValue;
    }

    /**
     * 值
     */
    public void setKeyValue(Double keyValue) {
        this.keyValue = keyValue;
    }

    /**
     * 描述
     */
    public String getKeyDesc() {
        return this.keyDesc;
    }

    /**
     * 描述
     */
    public void setKeyDesc(String keyDesc) {
        this.keyDesc = keyDesc;
    }

    /**
     *
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     *
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
