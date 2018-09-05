package com.kevin.concurrency.example.publish;

import com.kevin.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by Kevin on 2018/8/24.
 */
@Slf4j
@NotThreadSafe
public class UnSafePublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        log.info("{}", Arrays.toString(unSafePublish.getStates()));
        unSafePublish.getStates()[0] = "D";
        log.info("{}", Arrays.toString(unSafePublish.getStates()));
    }
}
