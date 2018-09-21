/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.CommuKeyvalueSetDao;
import com.zhiyun.entity.CommuKeyvalueSet;
import com.zhiyun.service.CommuKeyvalueSetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("commuKeyvalueSetService")
public class CommuKeyvalueSetServiceImpl extends BaseServiceImpl<CommuKeyvalueSet, Long> implements CommuKeyvalueSetService {

    @Resource
    private CommuKeyvalueSetDao commuKeyvalueSetDao;

    @Override
    protected BaseDao<CommuKeyvalueSet, Long> getBaseDao() {
        return this.commuKeyvalueSetDao;
    }

    @Override
    @Transactional
    public void addOrUpdate(CommuKeyvalueSet[] commuKeyvalueSets) {
        //清空所有
        CommuKeyvalueSet param = new CommuKeyvalueSet();
        param.setCompanyId(UserHolder.getCompanyId());
        param.setKeyId(commuKeyvalueSets[0].getKeyId());
        commuKeyvalueSetDao.deleteAllKeyValue(param);
        //然后再新增
        for (CommuKeyvalueSet commuKeyvalueSet : commuKeyvalueSets) {
            commuKeyvalueSet.setId(null);
            commuKeyvalueSet.setCompanyId(UserHolder.getCompanyId());
            commuKeyvalueSetDao.insert(commuKeyvalueSet);

        }
    }

    @Override
    @Transactional
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            commuKeyvalueSetDao.delete(id);
        }
    }

    @Override
    public List<CommuKeyvalueSet> optionValueByKeyId(String keyType) {
        Map<String, Object> map = new HashMap<>();
        map.put("companyId", UserHolder.getCompanyId());
        map.put("keyType", keyType);
        return commuKeyvalueSetDao.optionValueByKeyId(map);
    }
}
