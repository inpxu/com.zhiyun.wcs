/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.PathOneToManyDao;
import com.zhiyun.entity.PathOneToMany;
import com.zhiyun.service.PathOneToManyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 路径集登记Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("pathOneToManyService")
public class PathOneToManyServiceImpl extends BaseServiceImpl<PathOneToMany, Long> implements PathOneToManyService {

    @Resource
    private PathOneToManyDao pathOneToManyDao;

    @Override
    protected BaseDao<PathOneToMany, Long> getBaseDao() {
        return this.pathOneToManyDao;
    }
}
