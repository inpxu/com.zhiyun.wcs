/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.TaskRecordDao;
import com.zhiyun.entity.TaskRecord;
import org.springframework.stereotype.Repository;

/**
 * TaskRecordDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("taskRecordDao")
public class TaskRecordDaoImpl extends BaseDaoImpl<TaskRecord, Long> implements TaskRecordDao {

}
