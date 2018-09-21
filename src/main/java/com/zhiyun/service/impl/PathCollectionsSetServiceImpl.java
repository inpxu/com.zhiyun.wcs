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
import com.zhiyun.dto.PathCollectionsSetDto;
import com.zhiyun.dto.RelationDto;
import com.zhiyun.dao.PathCollectionsSetDao;
import com.zhiyun.dao.PathOneToManyDao;
import com.zhiyun.dao.SinglePathSetDao;
import com.zhiyun.entity.PathCollectionsSet;
import com.zhiyun.entity.PathOneToMany;
import com.zhiyun.entity.SinglePathSet;
import com.zhiyun.service.PathCollectionsSetService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 设备路径集Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("pathCollectionsSetService")
public class PathCollectionsSetServiceImpl extends BaseServiceImpl<PathCollectionsSet, Long> implements PathCollectionsSetService {

    @Resource
    private PathCollectionsSetDao pathCollectionsSetDao;
    @Autowired
    private SinglePathSetDao singlePathSetDao;
    @Autowired
    private PathOneToManyDao pathOneToManyDao;

    @Override
    protected BaseDao<PathCollectionsSet, Long> getBaseDao() {
        return this.pathCollectionsSetDao;
    }

    @Override
    public void addOrUpdate(PathCollectionsSet pathCollectionsSet) {
        if (pathCollectionsSet.getId() == null) {
            this.insert(pathCollectionsSet);
        } else {
            this.update(pathCollectionsSet);
        }
    }

    @Override
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            //TODO 判断是否被使用
            this.delete(id);

        }
    }

    @Override
    public DataGrid<PathCollectionsSetDto> customPage(Params entity, Pager pager) {
        return pathCollectionsSetDao.customPage(entity, pager);
    }

    @Override
    public PathCollectionsSetDto beforeAddSinglePath(PathCollectionsSet pathCollectionsSet) {
        PathCollectionsSetDto pathCollectionsSetDto = new PathCollectionsSetDto();
        //查询所有的单路径
        SinglePathSet param = new SinglePathSet();
        param.setCompanyId(pathCollectionsSet.getCompanyId());
        List<SinglePathSet> list = singlePathSetDao.findAllByCompanyId(param);
        pathCollectionsSetDto.setAllSinglePathSets(list);
        //已经被选择上的
        List<SinglePathSet> listed = pathCollectionsSetDao.findAllSelected(pathCollectionsSet);
        pathCollectionsSetDto.setSelectedpath(listed);
        return pathCollectionsSetDto;
    }

    @Override
    @Transactional
    public void saveRelations(RelationDto relationDto) {
        //TODO 新增前删除全部,方便删除和修改
        relationDto.setCompanyId(UserHolder.getCompanyId());
        //新增
        pathOneToManyDao.deleteByCollectionId(relationDto);
        PathOneToMany pathOneToMany = new PathOneToMany();
        Long pathCollectionId = relationDto.getPathCollectionId();
        Long[] singlePathIds = relationDto.getSinglePathId();
        if (ArrayUtils.isNotEmpty(singlePathIds)) {
            for (Long singlePathId : singlePathIds) {
                pathOneToMany.setSinglePathId(singlePathId);
                pathOneToMany.setCollectionId(pathCollectionId);
                pathOneToMany.setCompanyId(UserHolder.getCompanyId());
                pathOneToManyDao.insert(pathOneToMany);
                pathOneToMany.setId(null);
            }
        }
    }
}
