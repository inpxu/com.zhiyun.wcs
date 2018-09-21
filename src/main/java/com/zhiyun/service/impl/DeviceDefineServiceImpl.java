/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.DeviceDefineDao;
import com.zhiyun.entity.DeviceDefine;
import com.zhiyun.service.DeviceDefineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 物流设备定义Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("deviceDefineService")
public class DeviceDefineServiceImpl extends BaseServiceImpl<DeviceDefine, Long> implements DeviceDefineService {

    @Resource
    private DeviceDefineDao deviceDefineDao;

    @Override
    protected BaseDao<DeviceDefine, Long> getBaseDao() {
        return this.deviceDefineDao;
    }

    @Transactional
    @Override
    public void addOrUpdate(DeviceDefine deviceDefine) {
        if (deviceDefine.getId() == null) {
            this.insert(deviceDefine);
        } else {
            this.update(deviceDefine);
        }
    }

    @Override
    @Transactional
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            //TODO 判断是否被使用
            this.delete(id);
        }
    }
}
