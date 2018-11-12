package com.zy.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Horizon
 * Time: 下午4:47 2018/10/21
 * Description:
 */
@Slf4j
public class SynnchronizedExample2 {

    //修饰一个类
    public static void test1(int j) {
        synchronized (SynnchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} - {}", j,i);
            }
        }
    }

    //修饰一个静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} - {}", j,i);
        }
    }

    public static void main(String[] args) {
        SynnchronizedExample2 example1 = new SynnchronizedExample2();
        SynnchronizedExample2 example2 = new SynnchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            SynnchronizedExample2.test1(1);
        });
        executorService.execute(() -> {
            SynnchronizedExample2.test1(2);
        });
    }

}
