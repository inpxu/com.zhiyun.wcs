/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CommuDownDataPmsDao;
import com.zhiyun.entity.CommuDownDataPms;
import com.zhiyun.service.CommuDownDataPmsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 机联网下行数据Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("commuDownDataPmsService")
public class CommuDownDataPmsServiceImpl extends BaseServiceImpl<CommuDownDataPms, Long> implements CommuDownDataPmsService {

    @Resource
    private CommuDownDataPmsDao commuDownDataPmsDao;

    @Override
    protected BaseDao<CommuDownDataPms, Long> getBaseDao() {
        return this.commuDownDataPmsDao;
    }
}
