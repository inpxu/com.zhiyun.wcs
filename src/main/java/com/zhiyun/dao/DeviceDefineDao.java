/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.NetworkNoDto;
import com.zhiyun.dto.WarehouseAreaDto;
import com.zhiyun.entity.DeviceDefine;

import java.util.List;
import java.util.Map;

/**
 * DeviceDefineDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface DeviceDefineDao extends BaseDao<DeviceDefine, Long> {

    List<WarehouseAreaDto> optionWarehouseArea(Map<String, Object> map);

    List<NetworkNoDto> optionNetworkNo(Map<String, Object> map);
}
