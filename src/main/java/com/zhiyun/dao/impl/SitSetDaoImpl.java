/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.SitSetDao;
import com.zhiyun.dto.SitSetDto;
import com.zhiyun.entity.SitSet;
import com.zhiyun.vo.ProductionDeviceVo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SitSetDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("sitSetDao")
public class SitSetDaoImpl extends BaseDaoImpl<SitSet, Long> implements SitSetDao {

    @Override
    public DataGrid<SitSetDto> customPage(Params entity, Pager pager) {
        return selectPage(getMethodName(), entity, pager);
    }

    @Override
    public List<SitSet> optionSite(SitSet param) {
        return this.selectList(getMethodName(), param);
    }

    @Override
    public List<com.zhiyun.internal.wcs.SitSet> customFind(com.zhiyun.internal.wcs.SitSet sitSet) {
        return this.selectList(getMethodName(), sitSet);
    }

    @Override
    public com.zhiyun.internal.wcs.SitSet queryDetailById(Long id, Long companyId) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", id);
        map.put("companyId", companyId);
        return this.selectOne(getMethodName(), map);
    }

    @Override
    public List<com.zhiyun.internal.wcs.SitSet> getAllSitesNotInIds(Map<String, Object> map) {
        return this.selectList(getMethodName(), map);
    }

    @Override
    public List<SitSet> queryAllCompany() {
        return this.selectList(getMethodName(), new HashMap<>(1));
    }

    @Override
    public List<ProductionDeviceVo> optionProductionDeviceNo(Map<String, Object> map) {
        return this.selectList(getMethodName(), map);
    }

    @Override
    public SitSet getMac(SitSet sitSet) {
        return this.selectOne(getMethodName(), sitSet);
    }

}
