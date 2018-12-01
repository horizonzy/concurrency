package com.zy.concurrency.example.synccontainer;

import com.zy.concurrency.annotations.NotThreadSafe;
import com.zy.concurrency.annotations.ThreadSafe;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Horizon Time: 下午11:11 2018/11/27 Description:
 */
@Slf4j
@ThreadSafe
public class ColletionExample2 {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;


    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(finalI);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", set.size());
    }

    public static void update(int i) {
        set.add(i);
    }
}
