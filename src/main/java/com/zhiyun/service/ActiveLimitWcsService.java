/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.ActiveLimitWcsDto;
import com.zhiyun.entity.ActiveLimitWcs;

/**
 * 动作条件限制Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ActiveLimitWcsService extends BaseService<ActiveLimitWcs, Long> {

    void addOrUpdate(ActiveLimitWcsDto[] activeLimitWcs);

    void deleteByids(Long[] ids);
}
