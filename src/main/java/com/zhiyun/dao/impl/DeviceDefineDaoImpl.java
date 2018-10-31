/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.DeviceDefineDao;
import com.zhiyun.dto.NetworkNoDto;
import com.zhiyun.dto.WarehouseAreaDto;
import com.zhiyun.entity.DeviceDefine;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * DeviceDefineDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("deviceDefineDao")
public class DeviceDefineDaoImpl extends BaseDaoImpl<DeviceDefine, Long> implements DeviceDefineDao {

    @Override
    public List<WarehouseAreaDto> optionWarehouseArea(Map<String, Object> map) {
        return this.selectList(getMethodName(), map);
    }

    @Override
    public List<NetworkNoDto> optionNetworkNo(Map<String, Object> map) {
        return this.selectList(getMethodName(), map);
    }
}
