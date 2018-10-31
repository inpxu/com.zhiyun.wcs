/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.ProductionDeviceDto;
import com.zhiyun.dto.SitSetDto;
import com.zhiyun.entity.SitSet;

import java.util.List;
import java.util.Map;

/**
 * SitSetDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface SitSetDao extends BaseDao<SitSet, Long> {

    DataGrid<SitSetDto> customPage(Params entity, Pager pager);

    List<SitSet> optionSite(SitSet param);

    List<com.zhiyun.internal.wcs.SitSet> customFind(com.zhiyun.internal.wcs.SitSet sitSet);

    com.zhiyun.internal.wcs.SitSet queryDetailById(Long id, Long companyId);

    List<com.zhiyun.internal.wcs.SitSet> getAllSitesNotInIds(Map<String, Object> map);

    List<SitSet> queryAllCompany();

    List<ProductionDeviceDto> optionProductionDeviceNo(Map<String, Object> map);
}
