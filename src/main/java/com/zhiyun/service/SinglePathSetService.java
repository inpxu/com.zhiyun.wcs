/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.SinglePathSetDto;
import com.zhiyun.entity.SinglePathSet;

/**
 * 设备单路径设置Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface SinglePathSetService extends BaseService<SinglePathSet, Long> {
    /**
     * 新增或更新
     *
     * @param singlePathSet
     * @return void
     * @author 邓艺
     * @date 2018/9/7 10:18
     */
    void addOrUpdate(SinglePathSet singlePathSet);

    void deleteByIds(Long[] ids);

    DataGrid<SinglePathSetDto> customPage(Params entity, Pager pager);
}
