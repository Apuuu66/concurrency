package com.kevin.concurrency.example.cache;

/**
 * Created by Kevin on 2018/8/29.
 */
public class S {
    public static void main(String[] args) {
        int a[] = {1, 2, 3,-9, 8, -2, 6};
        int sum=a[0];
        int t = a[0];
        for (int i = 1; i < a.length; i++) {
            if (t>0) t += a[i];
            else t = a[i];
            if (t>sum) sum = t;
        }
        System.out.println(sum);
    }
}
