/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.entity.CommuKeyvalueSet;

import java.util.List;
import java.util.Map;

/**
 * CommuKeyvalueSetDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CommuKeyvalueSetDao extends BaseDao<CommuKeyvalueSet, Long> {

    void deleteAllKeyValue(CommuKeyvalueSet param);

    List<CommuKeyvalueSet> optionValueByKeyId(Map<String, Object> param);
}
