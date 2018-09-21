/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.TaskRecordDao;
import com.zhiyun.entity.TaskRecord;
import com.zhiyun.service.TaskRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 任务记录Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("taskRecordService")
public class TaskRecordServiceImpl extends BaseServiceImpl<TaskRecord, Long> implements TaskRecordService {

    @Resource
    private TaskRecordDao taskRecordDao;

    @Override
    protected BaseDao<TaskRecord, Long> getBaseDao() {
        return this.taskRecordDao;
    }
}
