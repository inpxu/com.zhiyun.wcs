/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.PathCollectionsSetDto;
import com.zhiyun.entity.PathCollectionsSet;
import com.zhiyun.entity.SinglePathSet;
import com.zhiyun.entity.SystemTask;

import java.util.List;
import java.util.Map;

/**
 * PathCollectionsSetDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface PathCollectionsSetDao extends BaseDao<PathCollectionsSet, Long> {

    DataGrid<PathCollectionsSetDto> customPage(Params entity, Pager pager);

    PathCollectionsSetDto beforeAddSinglePath(PathCollectionsSet pathCollectionsSet);

    List<SinglePathSet> findAllSelected(PathCollectionsSet pathCollectionsSet);

    Boolean isUsed(Map<String, Object> map);

    PathCollectionsSetDto shardingPathInfo(PathCollectionsSet systemTask);

    PathCollectionsSet findRealPath(SystemTask systemTask);
}
