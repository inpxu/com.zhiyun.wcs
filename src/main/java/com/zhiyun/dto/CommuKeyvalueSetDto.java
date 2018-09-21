package com.zhiyun.dto;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-15 11:19
 */
public class CommuKeyvalueSetDto {
    private Long keyId;
    // 值
    private Double keyValue;
    // 描述
    private String keyDesc;
    //
    private String remark;

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public Double getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(Double keyValue) {
        this.keyValue = keyValue;
    }

    public String getKeyDesc() {
        return keyDesc;
    }

    public void setKeyDesc(String keyDesc) {
        this.keyDesc = keyDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
