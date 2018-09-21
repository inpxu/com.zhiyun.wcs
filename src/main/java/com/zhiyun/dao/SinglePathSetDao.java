/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.SinglePathSetDto;
import com.zhiyun.entity.SinglePathSet;

import java.util.List;
import java.util.Map;

/**
 * SinglePathSetDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface SinglePathSetDao extends BaseDao<SinglePathSet, Long> {

    DataGrid<SinglePathSetDto> customPage(Params entity, Pager pager);

    List<SinglePathSet> findAllByCompanyId(SinglePathSet param);

    Boolean isUsed(Map<String, Object> aLong);
}
