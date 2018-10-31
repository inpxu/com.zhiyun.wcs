/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.CommuKeySetDao;
import com.zhiyun.dto.CommuKeySetDto;
import com.zhiyun.entity.CommuKeySet;
import com.zhiyun.service.CommuKeySetService;
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
@Service("commuKeySetService")
public class CommuKeySetServiceImpl extends BaseServiceImpl<CommuKeySet, Long> implements CommuKeySetService {

    @Resource
    private CommuKeySetDao commuKeySetDao;

    @Override
    protected BaseDao<CommuKeySet, Long> getBaseDao() {
        return this.commuKeySetDao;
    }

    @Override
    @Transactional
    public void addOrUpdate(CommuKeySet commuKeySet) {
        if (commuKeySet.getId() != null) {
            //修改
            commuKeySetDao.update(commuKeySet);
        } else {
            commuKeySetDao.insert(commuKeySet);
        }
    }

    @Override
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            commuKeySetDao.delete(id);
        }
    }

    @Override
    public CommuKeySetDto queryDetail(Long id) {
        CommuKeySet param = new CommuKeySet();
        param.setCompanyId(UserHolder.getCompanyId());
        param.setId(id);
        return commuKeySetDao.queryDetail(param);
    }

    @Override
    public DataGrid<CommuKeySet> customPage(Params entity, Pager pager) {
        return commuKeySetDao.customPage(entity, pager);
    }

    @Override
    public List<CommuKeySet> optionKey(String macNo) {
        CommuKeySet param = new CommuKeySet();
        param.setCompanyId(UserHolder.getCompanyId());
        param.setMacNo(macNo);
        return commuKeySetDao.optionKey(param);
    }
}
