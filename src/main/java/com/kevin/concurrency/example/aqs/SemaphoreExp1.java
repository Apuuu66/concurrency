package com.kevin.concurrency.example.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Kevin on 2018/8/25.
 */
@Slf4j
public class SemaphoreExp1 {
    private static int threadCount = 20;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    test(threadNum);
                    semaphore.release();
                    if (threadNum % 3 == 0) {
                        System.out.println("--------------"+threadNum+"-----------------");
                    }
                } catch (InterruptedException e) {
                    log.error("exception", e);
                } finally {
                }
            });
        }

        log.info("finished");
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
