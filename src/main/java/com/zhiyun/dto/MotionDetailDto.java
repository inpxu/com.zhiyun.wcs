package com.zhiyun.dto;

import com.zhiyun.entity.ActiveLimitWcs;
import com.zhiyun.entity.MotionSet;

import java.io.Serializable;
import java.util.List;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-06 14:13
 */
public class MotionDetailDto extends MotionSet implements Serializable {

    private static final long serialVersionUID = 5177352138883271254L;
    private List<ActiveLimitWcs> list;

    public List<ActiveLimitWcs> getList() {
        return list;
    }

    public void setList(List<ActiveLimitWcs> list) {
        this.list = list;
    }
}
