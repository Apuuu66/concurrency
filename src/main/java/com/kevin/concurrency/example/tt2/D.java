package com.kevin.concurrency.example.tt2;

import com.kevin.concurrency.example.tt1.Father;

/**
 * Created by Kevin on 2018/8/30.
 */
public class D extends Father {
    public static void main(String[] args) {
        Father father = new Father();
        D d = new D();
        System.out.println(d.param2);
        System.out.println(d.param3);


    }
}
