/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MathineNetworkWarnRecordDao;
import com.zhiyun.entity.MathineNetworkWarnRecord;
import com.zhiyun.service.MathineNetworkWarnRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 机联网告警记录Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("mathineNetworkWarnRecordService")
public class MathineNetworkWarnRecordServiceImpl extends BaseServiceImpl<MathineNetworkWarnRecord, Long> implements MathineNetworkWarnRecordService {

    @Resource
    private MathineNetworkWarnRecordDao mathineNetworkWarnRecordDao;

    @Override
    protected BaseDao<MathineNetworkWarnRecord, Long> getBaseDao() {
        return this.mathineNetworkWarnRecordDao;
    }
}
