package com.zhiyun.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-19 15:43
 */
@Data
public class JobPoolDto implements Serializable {

    private static final long serialVersionUID = 8802653370866617265L;
    /**
     * 任务名
     */
    private String jobName;
    private Long obId;

}
