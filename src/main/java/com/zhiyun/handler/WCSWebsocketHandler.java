package com.zhiyun.handler;

import com.alibaba.fastjson.JSON;
import com.zhiyun.service.InitialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;

/**
 * websocket自定义处理器
 *
 * @author 邓艺
 * @date 2018/9/10 16:17
 */
@Component
public class WCSWebsocketHandler implements WebSocketHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(WCSWebsocketHandler.class);
    private WebSocketSession session;
    @Autowired
    private InitialService initialService;

    /**
     * 连接成功时
     * 初始化websocketsession
     *
     * @return void
     * @author Bruce
     * @date 2018/9/8 23:37
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        session = webSocketSession;
        //        //握手成功以后将初始化数据推送至前端
        String msg = initialService.firstPush();
        webSocketSession.sendMessage(new TextMessage(JSON.toJSONString(msg)));

    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        LOGGER.error("websocket数据传输错误");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        LOGGER.info("websocket链接关闭");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 发送消息至前端
     *
     * @param msg
     * @return java.lang.Boolean
     * @author 邓艺
     * @date 2018/9/10 8:27
     */
    public Boolean sendMessage(String msg) {
        try {
            this.session.sendMessage(new TextMessage(msg));
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            return false;

        }
    }
}
