package com.zhiyun.dto;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 14:15
 */
public class JobInfoDto implements Serializable {

    private static final long serialVersionUID = 2516844368110239907L;
    private Long serialNumber;
    private Long jobNumber;
    private String deviceNo;
    private String destinationSiteName;
    private String jobStatus;
    private Long postJobNumber;

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Long jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDestinationSiteName() {
        return destinationSiteName;
    }

    public void setDestinationSiteName(String destinationSiteName) {
        this.destinationSiteName = destinationSiteName;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Long getPostJobNumber() {
        return postJobNumber;
    }

    public void setPostJobNumber(Long postJobNumber) {
        this.postJobNumber = postJobNumber;
    }
}
