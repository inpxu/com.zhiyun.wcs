package com.zhiyun.util;

import com.zhiyun.context.OnlineUser;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-20 09:11
 */
public class WebSocketHolder {
    /**
     * User对象标识
     */
    private static final String CONTEXT_ONLINE_USER = "user";
    private static final String CONTEXT_USER_KEY = "user-key";
    private static final String CONTEXT_REQUEST_IGNORE_AUTH = "request_ignore_auth";
    private static final String EXECUTE_UUID = "EXECUTE-UUID";
    private static ThreadLocal<Map<String, Object>> context = new ThreadLocal<>();

    /**
     * 清除线程数据
     */
    public static void clear() {
        Map<String, Object> map = context.get();
        if (map != null) {
            map.clear();
        }
        context.remove();
    }

    /**
     * 设置当前请求是否可以忽略权限认证
     */
    public static void setRequestIgnoreAuth() {
        setAttr(CONTEXT_REQUEST_IGNORE_AUTH, Boolean.TRUE);
    }

    /**
     * 返回当前请求是否可以忽略权限认证
     */
    public static boolean isRequestIgnoreAuth() {
        Boolean bool = getAttr(CONTEXT_REQUEST_IGNORE_AUTH);
        return bool == null ? false : bool.booleanValue();
    }

    /**
     * 判断当前线程数据是否有效
     *
     * @return
     */
    public static boolean isValid() {
        return getUser() != null;
    }

    /**
     * 获取用户标识
     *
     * @return
     */
    public static String getUserKey() {
        return getAttr(CONTEXT_USER_KEY);
    }

    /**
     * 设置用户标识
     *
     * @param userKey
     */
    public static void setUserKey(String userKey) {
        setAttr(CONTEXT_USER_KEY, userKey);
    }

    /**
     * 获取当前线程中的用户对象
     *
     * @return
     */
    public static OnlineUser getUser() {
        return getAttr(CONTEXT_ONLINE_USER);
    }

    /**
     * 将在线用户对象设置到当前线程中
     *
     * @param user
     */
    public static void setUser(OnlineUser user) {
        setAttr(CONTEXT_ONLINE_USER, user);
    }

    /**
     * 设置数据
     *
     * @param key 属性键
     * @param value 属性值
     */
    public static <T> void setAttr(String key, T value) {
        Map<String, Object> map = context.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            context.set(map);
        }
        map.put(key, value);
    }

    /**
     * 根据KEY返回数据
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getAttr(String key) {
        Map<String, Object> map = context.get();
        if (map != null) {
            return (T) map.get(key);
        }
        return null;
    }

    /**
     * 返回当前日期时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取当前用户标识
     *
     * @return 用户标识
     */
    public static Long getId() {
        return getUser().getId();
    }

    /**
     * 获取当前用户IP
     *
     * @return 用户标识
     */
    public static String getIp() {
        return getUser().getIp();
    }

    /**
     * 获取当前用户名称
     *
     * @return 用户名称
     */
    public static String getUserName() {
        return getUser().getUserName();
    }

    /**
     * 获取企业主键
     *
     * @return 企业主键
     */
    public static Long getCompanyId() {
        return getUser().getCompanyId();
    }

    /**
     * 获取企业名称
     *
     * @return 企业名称
     */
    public static String getCompanyName() {
        return getUser().getCompanyName();
    }

    /**
     * 获取部门主键
     *
     * @return 部门主键
     */
    public static Long getOrgId() {
        return getUser().getOrgId();
    }

    /**
     * 移除当前用户
     */
    public static void removeUser() {
        context.remove();
    }

    public static String getExecute() {
        return getAttr(EXECUTE_UUID);
    }

    //某个线程的uuid
    public static void setExecute(String uuid) {
        setAttr(EXECUTE_UUID, uuid);
    }
}
