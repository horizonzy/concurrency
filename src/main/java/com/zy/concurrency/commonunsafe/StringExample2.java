package com.zy.concurrency.commonunsafe;

import com.zy.concurrency.annotations.NotThreadSafe;
import com.zy.concurrency.annotations.ThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Horizon Time: 下午11:44 2018/11/12 Description:
 */
@Slf4j
@ThreadSafe
public class StringExample2 {


    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static StringBuffer buffer = new StringBuffer();


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
        log.info("size:{}", buffer.length());
    }

    public static void add() {
        buffer.append("1");
    }
}

