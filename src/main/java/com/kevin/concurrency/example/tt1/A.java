package com.kevin.concurrency.example.tt1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kevin on 2018/8/30.
 */
public class A {
    public double display(int a, int b) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();//记录余数个数的数据结构
        boolean isLoop = true;
        double count = 0d;
        int remainder = a % b;
        int mark = 0;
        //获取余数直到余数为零，或者出现余数相等判定为无限循环小数
        while (isLoop) {

            if (remainder == 0) {
                count = (double) a / (double) b;
                return count;
            } else if (!map.containsKey(remainder)) {
                map.put(remainder, mark);
                mark++;
            } else {
                count = mark - map.get(remainder);
                return count;
            }

            while (remainder < b) {
                remainder = remainder * 10;
            }
            remainder %= b;
        }
        return count;
    }


    public static void main(String[] arg) {
        A w = new A();
        double count = w.display(1, 3);
        System.out.println(count);
    }

}
