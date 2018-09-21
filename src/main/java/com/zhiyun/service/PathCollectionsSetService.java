/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.PathCollectionsSetDto;
import com.zhiyun.dto.RelationDto;
import com.zhiyun.entity.PathCollectionsSet;

/**
 * 设备路径集Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface PathCollectionsSetService extends BaseService<PathCollectionsSet, Long> {

    void addOrUpdate(PathCollectionsSet pathCollectionsSet);

    void deleteByIds(Long[] ids);

    DataGrid<PathCollectionsSetDto> customPage(Params entity, Pager pager);

    PathCollectionsSetDto beforeAddSinglePath(PathCollectionsSet pathCollectionsSet);

    void saveRelations(RelationDto relationDto);

}
