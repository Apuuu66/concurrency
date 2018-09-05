package com.kevin.concurrency.example.tt1;

/**
 * Created by Kevin on 2018/8/30.
 */
public class Father {
    private String param1 = "这是private";
    protected String param2 = "这是protected";
    public String param3 = "这是public";
    String param4 = "这是default";

    public static void main(String[] args) {
        Father father = new Father();
        System.out.println("father 实例访问：" + father.param1);
        System.out.println("father 实例访问：" + father.param2);
        System.out.println("father 实例访问：" + father.param3);
        System.out.println("father 实例访问：" + father.param4);
    }

}
