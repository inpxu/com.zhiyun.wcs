/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.CommuKeySetDto;
import com.zhiyun.entity.CommuKeySet;

import java.util.List;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CommuKeySetService extends BaseService<CommuKeySet, Long> {

    void addOrUpdate(CommuKeySet commuKeySet);

    void deleteByIds(Long[] ids);

    CommuKeySetDto queryDetail(Long id);

    DataGrid<CommuKeySet> customPage(Params entity, Pager pager);

    List<CommuKeySet> optionKey(String macNo);
}
