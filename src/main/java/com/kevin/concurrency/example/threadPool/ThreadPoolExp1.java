package com.kevin.concurrency.example.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kevin on 2018/8/28.
 */
public class ThreadPoolExp1 {
    private static volatile int i = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

        // ExecutorService executorService = Executors.newCachedThreadPool();
        for (int j = 0; j < 10; j++) {
            threadPoolExecutor.execute(() -> {
                add();
            });
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
        System.out.println(i);
    }

    private static void add() {

            i++;

    }
}
