package com.zhiyun.config;

import com.zhiyun.handler.WCSWebsocketHandler;
import com.zhiyun.intercepter.WCSWebsocketIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * websocket配置
 * 第一步实现websocketconfigurer接口重写registerWebSocketHandlers方法
 * 第二步，给回掉函数添加自定义处理器和自定义拦截器
 *
 * @author 邓艺
 * @date 2018/9/10 8:19
 */
@Component
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private WCSWebsocketHandler wcsWebsocketHandler;
    @Autowired
    private WCSWebsocketIntercepter wcsWebsocketIntercepter;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(wcsWebsocketHandler, "wcs").addInterceptors(wcsWebsocketIntercepter);

    }
}
