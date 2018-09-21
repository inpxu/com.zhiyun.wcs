package com.zhiyun.listener;

import com.rabbitmq.client.Channel;
import com.zhiyun.core.JobProcessEngine;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;

/**
 * 消息监听器,监听到消息以后将信息添加到任务队列中
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-07 10:59
 */
public class RabbitListener implements ChannelAwareMessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitListener.class);
    @Autowired
    private JobProcessEngine jobProcessEngine;

    /**
     * 消息处理回调函数
     *
     * @param message 消息
     * @param channel 通道
     * @author 邓艺
     * @date 2018/9/19 14:45
     */
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {

            String messageContent = new String(message.getBody(), StandardCharsets.UTF_8);
            if (StringUtils.isNotBlank(messageContent)) {
                //应答mq
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                jobProcessEngine.autoShardingJob(messageContent);
            } else {
                LOGGER.error("消息队列中任务为空");
            }

        } catch (Exception e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            LOGGER.error("消息监听器异常", e.getCause());
        }

    }
}
