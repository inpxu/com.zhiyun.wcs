package com.zhiyun.dto;

import java.io.Serializable;

/**
 * 单路径信息数据传输实体类
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 13:41
 */
public class SinglePathInfoDto implements Serializable {

    private static final long serialVersionUID = 5888941026260730444L;
    /**
     * 起点节点名
     */
    private String startSiteName;
    /**
     * 终点节点名
     */
    private String endSiteName;

    private String showName;

    public String getShowName() {
        return startSiteName + "->" + endSiteName;
    }

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
