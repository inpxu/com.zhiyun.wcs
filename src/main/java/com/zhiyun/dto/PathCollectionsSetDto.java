package com.zhiyun.dto;

import com.zhiyun.entity.PathCollectionsSet;
import com.zhiyun.entity.SinglePathSet;

import java.io.Serializable;
import java.util.List;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-10 19:55
 */
public class PathCollectionsSetDto extends PathCollectionsSet implements Serializable {

    private static final long serialVersionUID = 6752870760748632390L;
    private List<SinglePathSet> allSinglePathSets;
    private List<SinglePathSet> selectedpath;
    private String startPoint;
    private String endPoint;
    private String singlePathInfo;

    public String getSinglePathInfo() {
        return singlePathInfo;
    }

    public void setSinglePathInfo(String singlePathInfo) {
        this.singlePathInfo = singlePathInfo;
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

    public List<SinglePathSet> getAllSinglePathSets() {
        return allSinglePathSets;
    }

    public void setAllSinglePathSets(List<SinglePathSet> allSinglePathSets) {
        this.allSinglePathSets = allSinglePathSets;
    }

    public List<SinglePathSet> getSelectedpath() {
        return selectedpath;
    }

    public void setSelectedpath(List<SinglePathSet> selectedpath) {
        this.selectedpath = selectedpath;
    }
}
