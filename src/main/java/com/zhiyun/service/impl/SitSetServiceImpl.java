/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.DeviceDefineDao;
import com.zhiyun.dao.SinglePathSetDao;
import com.zhiyun.dao.SitSetDao;
import com.zhiyun.dto.ProductionDeviceDto;
import com.zhiyun.dto.SitSetDto;
import com.zhiyun.entity.DeviceDefine;
import com.zhiyun.entity.SitSet;
import com.zhiyun.service.SitSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备节点设置Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("sitSetService")
public class SitSetServiceImpl extends BaseServiceImpl<SitSet, Long> implements SitSetService {

    @Resource
    private SitSetDao sitSetDao;
    @Autowired
    private DeviceDefineDao deviceDefineDao;
    @Autowired
    private SinglePathSetDao singlePathSetDao;

    @Override
    protected BaseDao<SitSet, Long> getBaseDao() {
        return this.sitSetDao;
    }

    @Override
    @Transactional
    public void insertOrUpdate(SitSet sitSet) {
        if (sitSet.getId() == null) {
            //新增
            this.insert(sitSet);
        } else {
            this.update(sitSet);
        }
    }

    @Override
    @Transactional
    public void deleteBatchIds(List<Long> longs) {
        for (Long aLong : longs) {
            //TODO 删除时需要判断是否被使用中
            Map<String, Object> map = new HashMap<>();
            map.put("companyId", UserHolder.getCompanyId());
            map.put("id", aLong);
            Boolean b = singlePathSetDao.isUsed(map);
            if (b) {
                throw new BusinessException("节点被使用中，无法删除");
            } else {
                this.delete(aLong);
            }
        }

    }

    @Override
    public List<DeviceDefine> optionDeviceNo() {
        DeviceDefine deviceDefine = new DeviceDefine();
        deviceDefine.setCompanyId(UserHolder.getCompanyId());
        deviceDefine.setDeleted("F");
        return deviceDefineDao.find(deviceDefine);

    }

    @Override
    public DataGrid<SitSetDto> customPage(Params entity, Pager pager) {
        return sitSetDao.customPage(entity, pager);
    }

    @Override
    public List<SitSet> optionSite() {
        SitSet param = new SitSet();
        param.setCompanyId(UserHolder.getCompanyId());
        return sitSetDao.optionSite(param);
    }

    @Override
    public List<SitSet> queryAllCompany() {
        return sitSetDao.queryAllCompany();
    }

    @Override
    public List<ProductionDeviceDto> optionProductionDeviceNo() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("companyId", UserHolder.getCompanyId());
        return sitSetDao.optionProductionDeviceNo(map);
    }
}
