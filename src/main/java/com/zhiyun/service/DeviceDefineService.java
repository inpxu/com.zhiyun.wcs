/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.NetworkNoDto;
import com.zhiyun.dto.WarehouseAreaDto;
import com.zhiyun.entity.DeviceDefine;

import java.util.List;

/**
 * 物流设备定义Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface DeviceDefineService extends BaseService<DeviceDefine, Long> {

    void addOrUpdate(DeviceDefine deviceDefine);

    void deleteByIds(Long[] ids);

    List<WarehouseAreaDto> optionWarehouseArea();

    List<NetworkNoDto> optionNetworkNo();
}
