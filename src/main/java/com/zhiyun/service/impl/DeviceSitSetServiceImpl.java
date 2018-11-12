/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.DeviceSitSetDto;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.DeviceSitSetDao;
import com.zhiyun.entity.DeviceSitSet;
import com.zhiyun.service.DeviceSitSetService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("deviceSitSetService")
public class DeviceSitSetServiceImpl extends BaseServiceImpl<DeviceSitSet, Long> implements DeviceSitSetService {

	@Resource
	private DeviceSitSetDao deviceSitSetDao;

	@Override
	protected BaseDao<DeviceSitSet, Long> getBaseDao() {
		return this.deviceSitSetDao;
	}

	@Override
	public DataGrid<DeviceSitSetDto> customPage(Params entity, Pager pager) {
		return deviceSitSetDao.customPage(entity, pager);
	}

	@Override
	public void add(DeviceSitSetDto deviceSitSetDto) {
		String devicedNo = deviceSitSetDto.getDiviceNo();
		Long sitId = deviceSitSetDto.getSitId();
		DeviceSitSet deviceSitSet = new DeviceSitSet();
		deviceSitSet.setCompanyId(UserHolder.getCompanyId());
		deviceSitSet.setSitId(sitId);
		List<DeviceSitSet> list1 = deviceSitSetDao.find(deviceSitSet);
		if (list1.size()==2) {
			throw new BusinessException("该节点最多绑定两台设备！");
		}
		deviceSitSet.setDiviceNo(devicedNo);
		List<DeviceSitSet> list2 = deviceSitSetDao.find(deviceSitSet);
		if (list2.size()>=1) {
			throw new BusinessException("该节点已绑定该设备！");
		}
		deviceSitSetDao.insert(deviceSitSetDto);
	}



	@Override
	@Transactional
	public void del(Long[] ids) {
		for (Long id : ids) {
			deviceSitSetDao.delete(id);
		}
	}
}
