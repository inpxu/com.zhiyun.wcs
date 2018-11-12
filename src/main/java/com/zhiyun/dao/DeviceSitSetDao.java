/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.DeviceSitSetDto;
import com.zhiyun.dto.SystemTaskDto;
import com.zhiyun.entity.DeviceSitSet;

/**
 * DeviceSitSetDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface DeviceSitSetDao extends BaseDao<DeviceSitSet, Long> {

    DataGrid<DeviceSitSetDto> customPage(Params entity, Pager pager);
}
