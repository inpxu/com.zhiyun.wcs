/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.SystemTaskSingleDao;
import com.zhiyun.dto.SystemTaskSingleDto;
import com.zhiyun.entity.SystemTaskSingle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SystemTaskSingleDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("systemTaskSingleDao")
public class SystemTaskSingleDaoImpl extends BaseDaoImpl<SystemTaskSingle, Long> implements SystemTaskSingleDao {

    @Override
    public List<SystemTaskSingleDto> upDown(SystemTaskSingle systemTaskSingle) {
        return this.selectList(getMethodName(), systemTaskSingle);
    }
}
