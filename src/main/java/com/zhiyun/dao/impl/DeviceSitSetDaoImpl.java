/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.DeviceSitSetDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.DeviceSitSetDao;
import com.zhiyun.entity.DeviceSitSet;

/**
 * DeviceSitSetDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("deviceSitSetDao")
public class DeviceSitSetDaoImpl extends BaseDaoImpl<DeviceSitSet, Long> implements DeviceSitSetDao {

    @Override
    public DataGrid<DeviceSitSetDto> customPage(Params entity, Pager pager) {
        return this.selectPage(getMethodName(), entity, pager);
    }
}
