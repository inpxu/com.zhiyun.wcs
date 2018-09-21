/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CommuUpDataPmsDao;
import com.zhiyun.entity.CommuUpDataPms;
import com.zhiyun.service.CommuUpDataPmsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 机联网上行数据Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("commuUpDataPmsService")
public class CommuUpDataPmsServiceImpl extends BaseServiceImpl<CommuUpDataPms, Long> implements CommuUpDataPmsService {

    @Resource
    private CommuUpDataPmsDao commuUpDataPmsDao;

    @Override
    protected BaseDao<CommuUpDataPms, Long> getBaseDao() {
        return this.commuUpDataPmsDao;
    }
}
