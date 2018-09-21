package com.zhiyun.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-21 09:21
 */
@Component
public class WcsTopicListener implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(WcsTopicListener.class);

    @Override
    public void onMessage(Message message) {

    }
}
