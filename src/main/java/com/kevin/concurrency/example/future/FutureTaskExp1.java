package com.kevin.concurrency.example.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by Kevin on 2018/8/26.
 */
@Slf4j
public class FutureTaskExp1 {

    static class MyCallalbe implements Callable<String> {

        @Override
        public String call() throws Exception {
            log.info("do sth in callable");
            Thread.sleep(3000);
            return "Done";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do sth in callable");
                Thread.sleep(3000);
                return "Done";
            }
        });

       new Thread(futureTask).start();
       log.info("do something in main");
       Thread.sleep(1000);
        String s = futureTask.get();
        System.out.println(s);
    }
}
