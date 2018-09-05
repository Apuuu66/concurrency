package com.kevin.concurrency.example.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by Kevin on 2018/8/26.
 */
@Slf4j
public class FutureExp1 {

    static class MyCallalbe implements Callable<String> {

        @Override
        public String call() throws Exception {
            log.info("do sth in callable");
            Thread.sleep(3000);
            return "Done";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallalbe());
        log.info("do sth in main");
        Thread.sleep(1000);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
