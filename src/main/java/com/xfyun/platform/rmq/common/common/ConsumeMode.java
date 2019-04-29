package com.xfyun.platform.rmq.common.common;

/**
 * @Author: gaomq
 * @Date: 2019-04-28 9:30
 */
public enum ConsumeMode {
    /**
     * receive asynchronously delivered messages concurrently
     */
    CONCURRENTLY,

    /**
     * receive asynchronously delivered messages orderly. one queue, one thread
     */
    Orderly
}
