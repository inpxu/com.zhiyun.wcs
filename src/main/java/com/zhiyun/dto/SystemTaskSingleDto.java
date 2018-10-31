package com.zhiyun.dto;

import com.zhiyun.entity.SystemTaskSingle;

public class SystemTaskSingleDto extends SystemTaskSingle {

    private static final long serialVersionUID = 2025813763615032323L;

    private String startSiteName;
    private String endSiteName;

    public String getStartSiteName() {
        return startSiteName;
    }

    public void setStartSiteName(String startSiteName) {
        this.startSiteName = startSiteName;
    }

    public String getEndSiteName() {
        return endSiteName;
    }

    public void setEndSiteName(String endSiteName) {
        this.endSiteName = endSiteName;
    }
}