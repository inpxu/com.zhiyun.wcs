package com.zhiyun.dto;

import com.zhiyun.entity.DeviceSitSet;

public class DeviceSitSetDto extends DeviceSitSet {

    private static final long serialVersionUID = 1864694486751190064L;

    // 节点名称
    private String sitName;
    // 节点分类名称
    private String siteTypeName;
    // 生产设备名称
    private String prodMacMsg;

    public String getSitName() {
        return sitName;
    }

    public void setSitName(String sitName) {
        this.sitName = sitName;
    }

    public String getSiteTypeName() {
        return siteTypeName;
    }

    public void setSiteTypeName(String siteTypeName) {
        this.siteTypeName = siteTypeName;
    }

    public String getProdMacMsg() {
        return prodMacMsg;
    }

    public void setProdMacMsg(String prodMacMsg) {
        this.prodMacMsg = prodMacMsg;
    }

}