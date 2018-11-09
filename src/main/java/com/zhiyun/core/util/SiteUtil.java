package com.zhiyun.core.util;

import lombok.extern.slf4j.Slf4j;

/**
 * 站点工具类
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-11-08 12:42
 */
@Slf4j
public class SiteUtil {

    /**
     * 获取列值
     *
     * @param siteName 站点名
     * @return java.lang.Integer
     * @author 邓艺
     * @date 2018/11/8 15:02
     */
    public static Integer columnNumber(String siteName) {
        return Integer.parseInt(siteName.substring(0, 1));
    }

}
