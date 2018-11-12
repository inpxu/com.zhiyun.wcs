/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.ProductionDeviceDto;
import com.zhiyun.dto.SitSetDto;
import com.zhiyun.entity.DeviceDefine;
import com.zhiyun.entity.SitSet;

import java.util.List;

/**
 * 设备节点设置Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface SitSetService extends BaseService<SitSet, Long> {

    /**
     * 新增删除统一方法
     *
     * @param sitSet
     * @return boolean
     * @author 邓艺
     * @date 2018/9/7 9:04
     */
    void insertOrUpdate(SitSet sitSet);

    void deleteBatchIds(List<Long> longs);

    List<DeviceDefine> optionDeviceNo();

    DataGrid<SitSetDto> customPage(Params entity, Pager pager);

    List<SitSet> optionSite();

    List<SitSet> queryAllCompany();

    List<ProductionDeviceDto> optionProductionDeviceNo();

    SitSet getMac(SitSet sitSet);

    List<SitSetDto> findSit(SitSet sitSet);

}
