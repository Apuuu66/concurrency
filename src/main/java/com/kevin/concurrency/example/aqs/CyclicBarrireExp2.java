package com.kevin.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by Kevin on 2018/8/26.
 */
@Slf4j
public class CyclicBarrireExp2 {
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
            final int threadNum = i;
            exec.execute(() -> {
                race(threadNum);
            });
        }
        exec.shutdown();
    }

    private static void race(int threadNum) {
        log.info("{} is ready", threadNum);
        try {
            try {
                barrier.await(1000,TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                // e.printStackTrace();
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // e.printStackTrace();
        }
        log.info("{} is continue", threadNum);

    }
}
