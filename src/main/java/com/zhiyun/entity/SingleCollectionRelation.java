/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class SingleCollectionRelation extends BaseEntity<Long> {

    private static final long serialVersionUID = 6633197562739203105L;

    // ~~~~实体属性
    // 路径集id
    @Max(value = 9223372036854775807L, message = "路径集id字段过长")
    private Long pathCollectionId;
    // 单路径id
    @Max(value = 9223372036854775807L, message = "单路径id字段过长")
    private Long singlePathId;

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
    public Long getPathCollectionId() {
        return this.pathCollectionId;
    }

    /**
     * 路径集id
     */
    public void setPathCollectionId(Long pathCollectionId) {
        this.pathCollectionId = pathCollectionId;
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
}
