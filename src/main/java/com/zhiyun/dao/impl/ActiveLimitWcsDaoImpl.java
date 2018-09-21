/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.ActiveLimitWcsDao;
import com.zhiyun.entity.ActiveLimitWcs;
import org.springframework.stereotype.Repository;

/**
 * ActiveLimitWcsDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("activeLimitWcsDao")
public class ActiveLimitWcsDaoImpl extends BaseDaoImpl<ActiveLimitWcs, Long> implements ActiveLimitWcsDao {

    @Override
    public Boolean deleteByDeviceId(ActiveLimitWcs activeLimitWcs) {
        int update = this.update(getMethodName(), activeLimitWcs);
        return update != 0;
    }
}
