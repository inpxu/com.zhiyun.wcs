package com.zhiyun.dto;

import com.zhiyun.entity.SystemTask;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-11 16:45
 */
public class SystemTaskDto extends SystemTask implements Serializable {

    private static final long serialVersionUID = 2857878166945772245L;
    private String startPoint;
    private String endPoint;
    private String inMarkName;

    public String getInMarkName() {
        return inMarkName;
    }

    public void setInMarkName(String inMarkName) {
        this.inMarkName = inMarkName;
    }

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
