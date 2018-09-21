package com.zhiyun.dto;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 13:52
 */
public class MotionInfoDto implements Serializable {

    private static final long serialVersionUID = -4590652386586178561L;
    private String siteName;
    private String motionname;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getMotionname() {
        return motionname;
    }

    public void setMotionname(String motionname) {
        this.motionname = motionname;
    }
}
