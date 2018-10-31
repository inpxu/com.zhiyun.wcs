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
import com.zhiyun.dto.SinglePathInfoDto;
import com.zhiyun.dto.SystemTaskDto;
import com.zhiyun.dao.SystemTaskDao;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.service.SystemTaskService;
import com.zhiyun.internal.uniqueid.UniqueIdService;
import com.zhiyun.vo.SinglePathSetVo;
import org.apache.activemq.util.Suspendable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统任务表Service接口实现类。
 * 在手动新增物流任务以后将，相关的信息发送到队列，然后由自动分解任务将任务分解
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("systemTaskService")
public class SystemTaskServiceImpl extends BaseServiceImpl<SystemTask, Long> implements SystemTaskService {

    @Resource
    private SystemTaskDao systemTaskDao;

    //    @Autowired
    //    private AutoJobSharding autoJobSharding;
    @Autowired
    //注入dubbo接口时可能会出现不能注入提示，忽略即可
    private UniqueIdService uniqueIdService;

    @Override
    protected BaseDao<SystemTask, Long> getBaseDao() {
        return this.systemTaskDao;
    }

    @Override
    @Transactional
    public void addOrUpdate(SystemTask systemTask) {
        if (systemTask.getId() == null) {
            //新增时生成taskid
            systemTask.setTaskId(uniqueIdService.numberId());
            SystemTask insert = this.insert(systemTask);
            //判断是否新增成功，成功以后调用自动任务分割
            if (insert != null) {
                //autoJobSharding.addJonToQueue(JSON.toJSONString(insert));
            }
        } else {
            this.update(systemTask);
        }
    }

    @Override
    @Transactional
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            //提示是否删除
            this.delete(id);
        }
    }

    @Override
    public DataGrid<SystemTaskDto> customPage(Params entity, Pager pager) {
        return systemTaskDao.customPage(entity, pager);
    }

    @Override
    public List<SinglePathSetVo> queryAllSinglePath(SystemTask systemTask) {
        return systemTaskDao.queryAllSinglePath(systemTask);
    }

    @Override
    public List<SinglePathInfoDto> queryAllSinglePathInfo(SystemTask systemTask) {
        return systemTaskDao.queryAllSinglePathInfo(systemTask);
    }

    @Override
    public List<SystemTaskDto> upDownGet(SystemTask systemTask) {
        systemTask.setCompanyId(UserHolder.getCompanyId());
        return systemTaskDao.upDownGet(systemTask);
    }
    @Override
    public List<SystemTaskDto> moveBoxGet(SystemTask systemTask) {
        systemTask.setCompanyId(UserHolder.getCompanyId());
        return systemTaskDao.upDownGet(systemTask);
    }
}
