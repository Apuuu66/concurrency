package com.kevin.concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Kevin on 2018/8/29.
 */
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }
}
