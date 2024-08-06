package com.sensen.sensenshop.common.constant;

import lombok.Getter;

/**
 * @description:
 * @author: sensen
 * @date: 2024/8/4 18:48
 */
@Getter
public enum QueueEnum {

    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("sen.order.direct", "sen.order.cancel", "sen.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("sen.order.direct.ttl", "sen.order.cancel.ttl", "sen.order.cancel.ttl");

    /**
     * 交换名称
     */
    private final String exchange;
    /**
     * 队列名称
     */
    private final String name;
    /**
     * 路由键
     */
    private final String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
