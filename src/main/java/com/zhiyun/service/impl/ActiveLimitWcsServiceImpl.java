/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.ActiveLimitWcsDao;
import com.zhiyun.dto.ActiveLimitWcsDto;
import com.zhiyun.entity.ActiveLimitWcs;
import com.zhiyun.service.ActiveLimitWcsService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 动作条件限制Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("activeLimitWcsService")
public class ActiveLimitWcsServiceImpl extends BaseServiceImpl<ActiveLimitWcs, Long> implements ActiveLimitWcsService {

    @Resource
    private ActiveLimitWcsDao activeLimitWcsDao;

    @Override
    protected BaseDao<ActiveLimitWcs, Long> getBaseDao() {
        return this.activeLimitWcsDao;
    }

    @Override
    @Transactional
    public void addOrUpdate(ActiveLimitWcsDto[] activeLimitWcsDtos) {
        //先全部删除然后全部新增
        if (ArrayUtils.isNotEmpty(activeLimitWcsDtos)) {
            ActiveLimitWcsDto param = activeLimitWcsDtos[0];
            ActiveLimitWcs deleteParam = new ActiveLimitWcs();
            deleteParam.setCompanyId(UserHolder.getCompanyId());
            deleteParam.setdeviceId(param.getDeviceId());
            activeLimitWcsDao.deleteByDeviceId(deleteParam);

            for (ActiveLimitWcsDto activeLimitWcsDto : activeLimitWcsDtos) {
                ActiveLimitWcs insertParam = new ActiveLimitWcs();
                insertParam.setdeviceId(activeLimitWcsDto.getDeviceId());
                insertParam.setCompanyId(UserHolder.getCompanyId());
                insertParam.setLimitMem(activeLimitWcsDto.getLimitMem());
                insertParam.setLimitValue(activeLimitWcsDto.getLimitValue());
                insertParam.setLimitMacNo(activeLimitWcsDto.getLimitMacNo());
                activeLimitWcsDao.insert(insertParam);
            }

        }

    }

    @Override
    @Transactional
    public void deleteByids(Long[] ids) {
        this.delete(Arrays.asList(ids));
    }
}
