/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.entity.CommuKeyvalueSet;

import java.util.List;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CommuKeyvalueSetService extends BaseService<CommuKeyvalueSet, Long> {

    void addOrUpdate(CommuKeyvalueSet[] commuKeyvalueSet);

    void deleteByIds(Long[] ids);

    List<CommuKeyvalueSet> optionValueByKeyId(String keyType);
}
