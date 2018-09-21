package com.zhiyun.dto;

/**
 * 设备路径集参数封装实体
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-06 12:54
 */
public class RelationDto {
    private Long pathCollectionId;
    private Long[] singlePathId;
    private Long companyId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getPathCollectionId() {
        return pathCollectionId;
    }

    public void setPathCollectionId(Long pathCollectionId) {
        this.pathCollectionId = pathCollectionId;
    }

    public Long[] getSinglePathId() {
        return singlePathId;
    }

    public void setSinglePathId(Long[] singlePathId) {
        this.singlePathId = singlePathId;
    }
}
