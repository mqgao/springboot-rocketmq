package com.xfyun.platform.rmq.common.common;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *   保证当前实例的唯一性
 * @Author: gaomq
 * @Date: 2019-04-28 13:45
 */
public class RunTimeUtil {

    private static AtomicInteger index = new AtomicInteger();

    public static int getPid() {
        String info = getRunTimeInfo();
        int pid = (new Random()).nextInt();
        int index = info.indexOf("@");
        if(index > 0) {
            pid = Integer.parseInt(info.substring(0, index));
        }
        return pid;
    }
    public static String getRunTimeInfo() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String info = runtime.getName();
        return info;
    }
    public static String getRocketMqUniqeInstanceName() {
        return "pid" + getPid() + "_index" + index.incrementAndGet();
    }
}
