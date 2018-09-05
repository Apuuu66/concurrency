package com.kevin.concurrency.example.atomic;

import com.kevin.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by Kevin on 2018/8/24.
 * AtomicIntegerFieldUpdater
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {
    private static AtomicIntegerFieldUpdater<AtomicExample4> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample4.class, "count");
    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        final AtomicExample4 example4 = new AtomicExample4();

        if (updater.compareAndSet(example4, 100, 120)) {
            log.info("uodate success 1,{}", example4.getCount());
        }
        if (updater.compareAndSet(example4, 100, 120)) {
            log.info("uodate success 2,{}", example4.getCount());
        }
        if (updater.compareAndSet(example4, 120, 200)) {
            log.info("uodate success 3,{}", example4.getCount());
        }
    }
}
