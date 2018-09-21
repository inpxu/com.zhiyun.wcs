package com.zhiyun.dto;

import com.zhiyun.entity.CommuKeySet;
import com.zhiyun.entity.CommuKeyvalueSet;

import java.io.Serializable;
import java.util.List;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-15 10:18
 */
public class CommuKeySetDto extends CommuKeySet implements Serializable {

    private static final long serialVersionUID = -9192730303703486531L;
    private String directionType;
    private String yieldType;
    private List<CommuKeyvalueSet> commuKeyvalueSets;

    public String getDirectionType() {
        return directionType;
    }

    public void setDirectionType(String directionType) {
        this.directionType = directionType;
    }

    public String getYieldType() {
        return yieldType;
    }

    public void setYieldType(String yieldType) {
        this.yieldType = yieldType;
    }

    public List<CommuKeyvalueSet> getCommuKeyvalueSets() {
        return commuKeyvalueSets;
    }

    public void setCommuKeyvalueSets(List<CommuKeyvalueSet> commuKeyvalueSets) {
        this.commuKeyvalueSets = commuKeyvalueSets;
    }
}
