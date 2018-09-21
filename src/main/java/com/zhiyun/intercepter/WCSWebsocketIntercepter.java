package com.zhiyun.intercepter;

import com.zhiyun.client.UserHolder;
import com.zhiyun.util.WebSocketHolder;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * 自定义websocket拦截器，用于在握手之前对链接进行拦截
 *
 * @author 邓艺
 * @date 2018/9/12 9:15
 */
@Component
public class WCSWebsocketIntercepter implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler,
            Map<String, Object> map) throws Exception {
        WebSocketHolder.clear();
        WebSocketHolder.setUser(UserHolder.getUser());
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
