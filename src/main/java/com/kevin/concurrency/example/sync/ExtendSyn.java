package com.kevin.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Kevin on 2018/8/24.
 */
@Slf4j
public class ExtendSyn extends SynchronizedExample1 {
    @Override
    public void test1(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test1 -{}-{}", j,i);
        }
    }



    public static void main(String[] args) {
        ExtendSyn extendSyn1 = new ExtendSyn();
        ExtendSyn extendSyn2 = new ExtendSyn();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            extendSyn1.test2(1);
        });
        executorService.execute(() -> {
            extendSyn1.test2(2);
        });
    }
}
