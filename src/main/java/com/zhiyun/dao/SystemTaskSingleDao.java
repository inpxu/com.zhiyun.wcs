/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.SystemTaskSingleDto;
import com.zhiyun.entity.SystemTaskSingle;

import java.util.List;

/**
 * SystemTaskSingleDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface SystemTaskSingleDao extends BaseDao<SystemTaskSingle, Long> {

    List<SystemTaskSingleDto> upDown(SystemTaskSingle systemTaskSingle);

}
