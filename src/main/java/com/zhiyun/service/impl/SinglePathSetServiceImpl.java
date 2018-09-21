/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.SinglePathSetDto;
import com.zhiyun.dao.PathCollectionsSetDao;
import com.zhiyun.dao.SinglePathSetDao;
import com.zhiyun.entity.SinglePathSet;
import com.zhiyun.service.SinglePathSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 设备单路径设置Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("singlePathSetService")
public class SinglePathSetServiceImpl extends BaseServiceImpl<SinglePathSet, Long> implements SinglePathSetService {

    @Resource
    private SinglePathSetDao singlePathSetDao;
    @Autowired
    private PathCollectionsSetDao pathCollectionsSetDao;

    @Override
    protected BaseDao<SinglePathSet, Long> getBaseDao() {
        return this.singlePathSetDao;
    }

    @Transactional
    @Override
    public void addOrUpdate(SinglePathSet singlePathSet) {
        if (singlePathSet.getId() == null) {
            //新增
            this.insert(singlePathSet);
        } else {
            //更新
            this.update(singlePathSet);
        }
    }

    @Override
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            //TODO 判断路径是否被使用，如果被使用就不能删除
            Map<String, Object> map = new HashMap<>(2);
            map.put("companyId", UserHolder.getCompanyId());
            map.put("id", id);
            Boolean b = pathCollectionsSetDao.isUsed(map);
            if (b) {
                throw new BusinessException("单路径已经被使用，不能删除");
            } else {
                this.delete(id);
            }
        }
    }

    @Override
    public DataGrid<SinglePathSetDto> customPage(Params entity, Pager pager) {
        return singlePathSetDao.customPage(entity, pager);
    }
}
