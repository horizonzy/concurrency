package com.zy.concurrency.example.synccontainer;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VectorExample {

    public static int clientTotal = 5000;

    public static int threadTotal = 200;


    private static List<Integer> list = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        final Semaphore semaphore = new Semaphore(threadTotal);
//        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
//        for (int i = 0; i < clientTotal; i++) {
//            int finalI = i;
//            executorService.execute(() -> {
//                try {
//                    semaphore.acquire();
//                    update(finalI);
//                    semaphore.release();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//            });
//        }
//        countDownLatch.await();
//        executorService.shutdown();
//        log.info("size:{}",list.size() );
    }

    public static void update(int i) {
        list.add(i);
    }

}
