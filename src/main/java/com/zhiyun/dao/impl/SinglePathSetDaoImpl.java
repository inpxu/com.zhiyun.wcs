/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.SinglePathSetDto;
import com.zhiyun.dao.SinglePathSetDao;
import com.zhiyun.entity.SinglePathSet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * SinglePathSetDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("singlePathSetDao")
public class SinglePathSetDaoImpl extends BaseDaoImpl<SinglePathSet, Long> implements SinglePathSetDao {

    @Override
    public DataGrid<SinglePathSetDto> customPage(Params entity, Pager pager) {
        return this.selectPage(getMethodName(), entity, pager);
    }

    @Override
    public List<SinglePathSet> findAllByCompanyId(SinglePathSet param) {
        return this.selectList(getMethodName(), param);
    }

    @Override
    public Boolean isUsed(Map<String, Object> aLong) {
        return this.selectOne(getMethodName(), aLong);
    }
}
