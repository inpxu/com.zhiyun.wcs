package com.zhiyun.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-10-31 10:18
 */
@Data
public class ProductionDeviceDto implements Serializable {

    private static final long serialVersionUID = -1275904802764409152L;
    /**
     * 设备名
     */
    private String deviceName;
    /**
     * 设备编码
     */
    private String deviceNo;

}
