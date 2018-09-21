/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.CommuKeyvalueSetDao;
import com.zhiyun.entity.CommuKeyvalueSet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CommuKeyvalueSetDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("commuKeyvalueSetDao")
public class CommuKeyvalueSetDaoImpl extends BaseDaoImpl<CommuKeyvalueSet, Long> implements CommuKeyvalueSetDao {

    @Override
    public void deleteAllKeyValue(CommuKeyvalueSet param) {
        this.update(getMethodName(), param);
    }

    @Override
    public List<CommuKeyvalueSet> optionValueByKeyId(Map<String, Object> map) {
        return this.selectList(getMethodName(), map);
    }
}
