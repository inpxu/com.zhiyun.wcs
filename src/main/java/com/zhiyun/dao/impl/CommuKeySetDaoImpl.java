/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.CommuKeySetDao;
import com.zhiyun.dto.CommuKeySetDto;
import com.zhiyun.entity.CommuKeySet;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CommuKeySetDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("commuKeySetDao")
public class CommuKeySetDaoImpl extends BaseDaoImpl<CommuKeySet, Long> implements CommuKeySetDao {

    @Override
    public CommuKeySetDto queryDetail(CommuKeySet param) {
        return this.selectOne(getMethodName(), param);
    }

    @Override
    public DataGrid<CommuKeySet> customPage(Params entity, Pager pager) {
        return this.selectPage(getMethodName(), entity, pager);
    }

    @Override
    public List<CommuKeySet> optionKey(CommuKeySet param) {
        return this.selectList(getMethodName(), param);
    }
}
