package com.zhiyun.dto;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 15:43
 */
public class JobPoolDto implements Serializable {

    private static final long serialVersionUID = 8802653370866617265L;
    private String JobName;
    private Long JobId;

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public Long getJobId() {
        return JobId;
    }

    public void setJobId(Long jobId) {
        JobId = jobId;
    }
}
