package com.zy.concurrency.example.atomic;

import com.zy.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Horizon
 * Time: 下午11:21 2018/6/19
 * Description:
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {
    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        log.info("count:{}",count.getAndSet(5));
        log.info("count:{}",count.get());
    }
}
