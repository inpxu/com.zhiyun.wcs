package com.zhiyun.dto;

import com.zhiyun.entity.SitSet;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-10 15:11
 */
public class SitSetDto extends SitSet implements Serializable {

    private static final long serialVersionUID = -6728199897151181819L;
    private String siteTypeName;

    public String getSiteTypeName() {
        return siteTypeName;
    }

    public void setSiteTypeName(String siteTypeName) {
        this.siteTypeName = siteTypeName;
    }
}
