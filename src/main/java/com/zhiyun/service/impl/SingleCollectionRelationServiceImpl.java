/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.SingleCollectionRelationDao;
import com.zhiyun.entity.SingleCollectionRelation;
import com.zhiyun.service.SingleCollectionRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("singleCollectionRelationService")
public class SingleCollectionRelationServiceImpl extends BaseServiceImpl<SingleCollectionRelation, Long> implements SingleCollectionRelationService {

    @Resource
    private SingleCollectionRelationDao singleCollectionRelationDao;

    @Override
    protected BaseDao<SingleCollectionRelation, Long> getBaseDao() {
        return this.singleCollectionRelationDao;
    }
}
