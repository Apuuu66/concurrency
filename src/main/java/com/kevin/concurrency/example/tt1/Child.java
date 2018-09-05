package com.kevin.concurrency.example.tt1;

/**
 * Created by Kevin on 2018/8/30.
 */
public class Child extends Father {
    public static void main(String[] args) {
        Father father = new Father();
        System.out.println(father.param2);
        System.out.println(father.param3);
        System.out.println(father.param4);
        System.out.println();
        Child child = new Child();
        System.out.println(child.param2);
        System.out.println(child.param3);
        System.out.println(child.param4);
    }

}
