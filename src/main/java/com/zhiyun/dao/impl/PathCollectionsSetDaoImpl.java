/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.PathCollectionsSetDao;
import com.zhiyun.dto.PathCollectionsSetDto;
import com.zhiyun.entity.PathCollectionsSet;
import com.zhiyun.entity.SinglePathSet;
import com.zhiyun.entity.SystemTask;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * PathCollectionsSetDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("pathCollectionsSetDao")
public class PathCollectionsSetDaoImpl extends BaseDaoImpl<PathCollectionsSet, Long> implements PathCollectionsSetDao {

    @Override
    public DataGrid<PathCollectionsSetDto> customPage(Params entity, Pager pager) {
        return this.selectPage(getMethodName(), entity, pager);
    }

    @Override
    public PathCollectionsSetDto beforeAddSinglePath(PathCollectionsSet pathCollectionsSet) {
        List<PathCollectionsSetDto> objects = this.selectList(getMethodName(), pathCollectionsSet);
        //使用list防止脏数据出现导致报错
        if (CollectionUtils.isNotEmpty(objects)) {
            return objects.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<SinglePathSet> findAllSelected(PathCollectionsSet pathCollectionsSet) {
        return this.selectList(getMethodName(), pathCollectionsSet);
    }

    @Override
    public Boolean isUsed(Map<String, Object> map) {
        return this.selectOne(getMethodName(), map);
    }

    @Override
    public PathCollectionsSetDto shardingPathInfo(PathCollectionsSet systemTask) {
        return this.selectOne(getMethodName(), systemTask);
    }

    @Override
    public PathCollectionsSet findRealPath(SystemTask systemTask) {
        return this.selectOne(getMethodName(), systemTask);
    }
}
