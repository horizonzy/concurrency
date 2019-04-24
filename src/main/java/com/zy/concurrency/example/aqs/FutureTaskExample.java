package com.zy.concurrency.example.aqs;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Horizon
 * @time: 00:53 2019-04-25
 * @description:
 */
@Slf4j
public class FutureTaskExample {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "done";
        });

        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        String s = futureTask.get();
        log.info("result: {}", s);
    }

}
