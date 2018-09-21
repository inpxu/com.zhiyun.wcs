/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;

/**
 * 路径集登记实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class PathOneToMany extends BaseEntity<Long> {

    private static final long serialVersionUID = 4681205604279660090L;

    // ~~~~实体属性
    // 路径集id
    @Max(value = 9223372036854775807L, message = "路径集id字段过长")
    private Long collectionId;
    // 单路径id
    @Max(value = 9223372036854775807L, message = "单路径id字段过长")
    private Long singlePathId;
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
     * 路径集id
     */
    public Long getCollectionId() {
        return this.collectionId;
    }

    /**
     * 路径集id
     */
    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * 单路径id
     */
    public Long getSinglePathId() {
        return this.singlePathId;
    }

    /**
     * 单路径id
     */
    public void setSinglePathId(Long singlePathId) {
        this.singlePathId = singlePathId;
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
