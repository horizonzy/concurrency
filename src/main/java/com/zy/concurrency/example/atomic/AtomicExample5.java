package com.zy.concurrency.example.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by Horizon Time: 下午11:27 2018/6/19 Description:
 */
@Slf4j
public class AtomicExample5 {

    @Getter
    private volatile int count = 100;

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater
            .newUpdater(AtomicExample5.class, "count");


    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();
        if (updater.compareAndSet(example5, 100, 200)) {
            log.info("update success 1, {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 200)) {
            log.info("update success 2 , {}", example5.getCount());
        } else {
            log.info("update failure,{}", example5.getCount());
        }

    }


}
