/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.entity.ActiveLimitWcs;
import com.zhiyun.entity.MotionSet;

import java.util.List;

/**
 * 设备动作设置Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface MotionSetService extends BaseService<MotionSet, Long> {
    /**
     * 新增或者删除统一接口
     *
     * @param motionSet
     * @return void
     * @author 邓艺
     * @date 2018/9/7 9:10
     */
    void addOrUpdate(MotionSet motionSet);

    void deleteByids(Long[] ids);

    /**
     * 查询动作详情，只用查询设备动作限制即可
     *
     * @param id
     * @return com.zhiyun.dto.MotionDetailDto
     * @author 邓艺
     * @date 2018/9/7 13:40
     */
    List<ActiveLimitWcs> findDetail(Long id);
}
