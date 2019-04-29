package com.xfyun.platform.rmq.common.common;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: gaomq
 * @Date: 2019-04-28 9:23
 */
public class DefaultRocketMqProducer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private DefaultMQProducer producer;

    /**
     * send msg.
     *
     * @param msg content
     * @return send result
     */
    public boolean sendMsg(Message msg) {
        SendResult sendResult = null;
        try {
            sendResult = producer.send(msg);
            logger.info(sendResult.toString());
        } catch (Exception e) {
            logger.error("send msg error", e);
        }
        return sendResult != null && sendResult.getSendStatus() == SendStatus.SEND_OK;
    }

    /**
     * sene one way msg.
     *
     * @param msg msg
     */
    public void sendOneWayMsg(Message msg) {
        try {
            producer.sendOneway(msg);
        } catch (Exception e) {
            logger.error("send msg error", e);
        }
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }

    public void setProducer(DefaultMQProducer producer) {
        this.producer = producer;
    }

    public void destroy() {
        if (Objects.nonNull(producer)) {
            producer.shutdown();
        }
    }
}
