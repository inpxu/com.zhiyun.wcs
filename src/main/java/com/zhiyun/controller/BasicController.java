package com.zhiyun.controller;

import com.zhiyun.base.exception.BusinessException;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 基础controller
 * 目的封装常用基本方法
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-06 10:45
 */
public class BasicController {

    /**
     * 参数校验方法
     *
     * @param
     * @return void
     * @author 邓艺
     * @date 2018/9/6 10:48
     */
    public void validateParam(BindingResult bindingResult) {
        //参数不合法
        if (bindingResult.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                sb.append(fieldError.getField());
                sb.append(",");
            }
            String fildErrors = sb.toString();
            throw new BusinessException(fildErrors.substring(0, fildErrors.length() - 1));
        }
    }

    /**
     * 校验删除时id数组是否正常
     *
     * @param
     * @return void
     * @author 邓艺
     * @date 2018/9/6 11:05
     */
    public void validateIds(Long[] ids) {
        if (ArrayUtils.isEmpty(ids)) {
            throw new BusinessException("数据标识不能为空");
        }

    }
}
