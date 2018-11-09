package com.zhiyun.service;

import com.zhiyun.entity.SystemTask;

public interface DispatcherService {
    Boolean changeOrder();

    void startMission(SystemTask systemTask);
}
