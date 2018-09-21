package com.zhiyun.vo;

import com.zhiyun.entity.SinglePathSet;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-20 13:14
 */
public class SinglePathSetVo extends SinglePathSet {
    private String destinationSiteName;

    public String getDestinationSiteName() {
        return destinationSiteName;
    }

    public void setDestinationSiteName(String destinationSiteName) {
        this.destinationSiteName = destinationSiteName;
    }
}
