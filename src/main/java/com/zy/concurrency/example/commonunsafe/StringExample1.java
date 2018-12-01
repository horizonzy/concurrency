package com.zy.concurrency.example.commonunsafe;

import com.zy.concurrency.annotations.NotThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Horizon Time: 下午11:44 2018/11/12 Description:
 */
@Slf4j
@NotThreadSafe
public class StringExample1 {


    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static StringBuilder builder = new StringBuilder();


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", builder.length());
    }

    public static void add() {
        builder.append("1");
    }
}

