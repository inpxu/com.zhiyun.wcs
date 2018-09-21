/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.CommuKeySetDto;
import com.zhiyun.entity.CommuKeySet;

import java.util.List;

/**
 * CommuKeySetDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CommuKeySetDao extends BaseDao<CommuKeySet, Long> {

    CommuKeySetDto queryDetail(CommuKeySet param);

    DataGrid<CommuKeySet> customPage(Params entity, Pager pager);

    List<CommuKeySet> optionKey(CommuKeySet param);
}
