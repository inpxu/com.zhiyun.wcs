package com.zhiyun.service;

import com.zhiyun.dao.SitSetDao;
import com.zhiyun.internal.wcs.SitSet;
import com.zhiyun.internal.wcs.WcsService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-11 11:08
 */
@Service("wcsServiceImpl")
public class WcsServiceImpl implements WcsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WcsServiceImpl.class);
    @Autowired
    private SitSetDao sitSetDao;

    @Override
    public List<SitSet> getAllSites(Long companyId) {
        SitSet sitSet = new SitSet();
        sitSet.setCompanyId(companyId);
        sitSet.setDeleted("F");
        return sitSetDao.customFind(sitSet);
    }

    @Override
    public List<SitSet> getAllSites(Long companyId, Integer siteType) {
        SitSet sitSet = new SitSet();
        sitSet.setCompanyId(companyId);
        sitSet.setDeleted("F");
        sitSet.setSiteType(siteType);
        return sitSetDao.customFind(sitSet);
    }

    @Override
    public List<SitSet> getAllSitesNotInIds(Long companyId, List<Long> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            Map<String, Object> map = new HashMap<>(3);
            map.put("companyId", companyId);
            map.put("ids", StringUtils.join(ids.toArray(), ","));
            return sitSetDao.getAllSitesNotInIds(map);
        } else {
            LOGGER.error("查询非给定id节点传入id集合为空");
            return null;
        }
    }

    @Override
    public SitSet queryDetailById(Long id, Long companyId) {
        return sitSetDao.queryDetailById(id, companyId);
    }

}
