/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dto.RelationDto;
import com.zhiyun.dao.PathOneToManyDao;
import com.zhiyun.entity.PathOneToMany;
import org.springframework.stereotype.Repository;

/**
 * PathOneToManyDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("pathOneToManyDao")
public class PathOneToManyDaoImpl extends BaseDaoImpl<PathOneToMany, Long> implements PathOneToManyDao {

    @Override
    public void deleteByCollectionId(RelationDto relationDto) {
        this.delete(getMethodName(), relationDto);
    }
}
