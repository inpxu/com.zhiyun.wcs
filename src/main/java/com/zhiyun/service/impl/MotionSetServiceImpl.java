/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.ActiveLimitWcsDao;
import com.zhiyun.dao.MotionSetDao;
import com.zhiyun.entity.ActiveLimitWcs;
import com.zhiyun.entity.MotionSet;
import com.zhiyun.service.MotionSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 设备动作设置Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("motionSetService")
public class MotionSetServiceImpl extends BaseServiceImpl<MotionSet, Long> implements MotionSetService {

    @Resource
    private MotionSetDao motionSetDao;
    @Autowired
    private ActiveLimitWcsDao activeLimitWcsDao;

    @Override
    protected BaseDao<MotionSet, Long> getBaseDao() {
        return this.motionSetDao;
    }

    @Transactional
    @Override
    public void addOrUpdate(MotionSet motionSet) {
        if (motionSet.getId() == null) {
            //新增
            this.insert(motionSet);
        } else {
            this.update(motionSet);
        }
    }

    @Transactional
    @Override
    public void deleteByids(Long[] ids) {
        for (Long id : ids) {
            this.delete(id);
        }
    }

    @Override
    public List<ActiveLimitWcs> findDetail(Long id) {
        ActiveLimitWcs param = new ActiveLimitWcs();
        param.setdeviceId(id);
        param.setCompanyId(UserHolder.getCompanyId());
        param.setDeleted("F");
        return activeLimitWcsDao.find(param);
    }
}
