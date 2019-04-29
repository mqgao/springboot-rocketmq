package com.xfyun.platform.rmq.common.common;

import java.util.List;

/**
 * @Author: gaomq
 * @Date: 2019-04-28 9:40
 */
public class RocketMqConsumerMBean {

    /**
     * consumer beans container.
     *
     */
    private List<AbstractRocketMqConsumer> consumers;

    public List<AbstractRocketMqConsumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<AbstractRocketMqConsumer> consumers) {
        this.consumers = consumers;
    }
}
