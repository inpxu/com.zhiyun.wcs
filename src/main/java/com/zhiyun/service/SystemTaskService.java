/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.SinglePathInfoDto;
import com.zhiyun.dto.SystemTaskDto;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.vo.SinglePathSetVo;

import java.util.List;

/**
 * 系统任务表Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface SystemTaskService extends BaseService<SystemTask, Long> {

    void addOrUpdate(SystemTask systemTask);

    void deleteByIds(Long[] ids);

    DataGrid<SystemTaskDto> customPage(Params entity, Pager pager);

    /**
     * 通过任务查询所有单路径集合
     *
     * @param systemTask
     * @return java.util.List<com.zhiyun.entity.SinglePathSet>
     * @author 邓艺
     * @date 2018/9/19 15:02
     */
    List<SinglePathSetVo> queryAllSinglePath(SystemTask systemTask);

    List<SinglePathInfoDto> queryAllSinglePathInfo(SystemTask systemTask);
}
