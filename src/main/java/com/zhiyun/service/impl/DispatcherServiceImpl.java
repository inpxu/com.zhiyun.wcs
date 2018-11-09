package com.zhiyun.service.impl;

import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.core.JobProcessEngine;
import com.zhiyun.dao.SystemTaskSingleDao;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.entity.SystemTaskSingle;
import com.zhiyun.service.DispatcherService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatcherServiceImpl implements DispatcherService {
    @Autowired
    private SystemTaskSingleDao systemTaskSingleDao;
    @Autowired
    private JobProcessEngine jobProcessEngine;
    @Value("${needRunTaskId}")
    private Long needRunTaskId;



    @Override
    public Boolean changeOrder() {
        return null;
    }

    @Override
    public void startMission(SystemTask systemTask) {
        //根据taskid查询出所有的分解任务
        SystemTaskSingle param = new SystemTaskSingle();
        param.setCompanyId(UserHolder.getCompanyId());
        param.setDeleted("F");
        param.setTaskId(systemTask.getTaskId());
        List<SystemTaskSingle> systemTaskSingles = systemTaskSingleDao.find(param);
        if (CollectionUtils.isNotEmpty(systemTaskSingles)) {
            //是否是指定需要运行的任务
            if (systemTask.getTaskId().equals(needRunTaskId)) {
                jobProcessEngine.sendMissionToDevice(systemTaskSingles);
            }
        }else{
            throw new BusinessException("任务未分解");
        }

    }
}
