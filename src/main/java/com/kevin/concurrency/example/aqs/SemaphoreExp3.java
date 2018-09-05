package com.kevin.concurrency.example.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kevin on 2018/8/25.
 * 设置获取许可数量
 * 尝试获取许可，如果可以则执行，否则抛弃
 */
@Slf4j
public class SemaphoreExp3 {
    private static int threadCount = 20;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    if (semaphore.tryAcquire(3, 1, TimeUnit.SECONDS)) {
                        test(threadNum);
                        semaphore.release(3);
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
        Thread.sleep(100);
    }
}
