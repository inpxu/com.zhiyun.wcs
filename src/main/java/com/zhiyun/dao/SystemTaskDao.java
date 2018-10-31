/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.SinglePathInfoDto;
import com.zhiyun.dto.SystemTaskDto;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.vo.SinglePathSetVo;

import java.util.List;

/**
 * SystemTaskDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface SystemTaskDao extends BaseDao<SystemTask, Long> {

    DataGrid<SystemTaskDto> customPage(Params entity, Pager pager);

    List<SinglePathSetVo> queryAllSinglePath(SystemTask systemTask);

    List<SinglePathInfoDto> queryAllSinglePathInfo(SystemTask systemTask);

    List<SystemTaskDto> upDownGet(SystemTask systemTask);


    List<SystemTaskDto> moveBoxGet(SystemTask systemTask);
}
