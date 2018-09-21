package com.zhiyun.dto;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-06 10:13
 */
public class ResultModel<T> implements Serializable {

    private static final long serialVersionUID = 6583868299579847389L;
    private Boolean result = true;
    private String message;
    private T model;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
