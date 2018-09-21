package com.zhiyun.dto;

import com.zhiyun.entity.SinglePathSet;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-10 18:28
 */
public class SinglePathSetDto extends SinglePathSet implements Serializable {

    private static final long serialVersionUID = -7119713897536802807L;
    private String startPoint;
    private String endPoint;

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
