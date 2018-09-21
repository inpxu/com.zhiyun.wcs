/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.SinglePathInfoDto;
import com.zhiyun.dto.SystemTaskDto;
import com.zhiyun.dao.SystemTaskDao;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.vo.SinglePathSetVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SystemTaskDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("systemTaskDao")
public class SystemTaskDaoImpl extends BaseDaoImpl<SystemTask, Long> implements SystemTaskDao {

    @Override
    public DataGrid<SystemTaskDto> customPage(Params entity, Pager pager) {
        return this.selectPage(getMethodName(), entity, pager);
    }

    @Override
    public List<SinglePathSetVo> queryAllSinglePath(SystemTask systemTask) {
        return this.selectList(getMethodName(), systemTask);
    }

    @Override
    public List<SinglePathInfoDto> queryAllSinglePathInfo(SystemTask systemTask) {
        return this.selectList(getMethodName(), systemTask);
    }
}
