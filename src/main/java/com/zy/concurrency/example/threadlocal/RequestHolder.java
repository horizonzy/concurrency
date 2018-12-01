package com.zy.concurrency.example.threadlocal;

/**
 * Created by Horizon Time: 下午4:16 2018/11/11 Description:
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }


}
