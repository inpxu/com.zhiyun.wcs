/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.SystemTaskSingleDao;
import com.zhiyun.dto.SystemTaskSingleDto;
import com.zhiyun.entity.SystemTaskSingle;
import com.zhiyun.service.SystemTaskSingleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("systemTaskSingleService")
public class SystemTaskSingleServiceImpl extends BaseServiceImpl<SystemTaskSingle, Long> implements SystemTaskSingleService {

    @Resource
    private SystemTaskSingleDao systemTaskSingleDao;

    @Override
    protected BaseDao<SystemTaskSingle, Long> getBaseDao() {
        return this.systemTaskSingleDao;
    }

    @Override
    public List<SystemTaskSingleDto> upDown(SystemTaskSingle systemTaskSingle) {
        return systemTaskSingleDao.upDown(systemTaskSingle);
    }

    @Override
    @Transactional
    public void del(Long[] ids) {
        for (Long id : ids) {
            systemTaskSingleDao.delete(id);
        }
    }
}
