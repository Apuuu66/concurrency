package com.kevin.concurrency.example.future;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kevin on 2018/8/27.
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] flowers = new int[m + 1];
        int[] see = new int[n + 1];
        for (int i = 1; i < flowers.length; i++) {
            flowers[i] = i;
        }
        for (int i = 1; i < see.length; i++) {
            see[i] = in.nextInt();
        }
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            kinds(a, b, flowers, see);
        }
    }

    private static void kinds(int a, int b, int[] flowers, int[] see) {
        int kinds = 0;
        int[] count = new int[flowers.length];
        Arrays.fill(count, 0);
        for (int i = a; i <= b; i++) {
            int t = see[i];
            count[t] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] != 0) {
                kinds++;
            }
        }
        System.out.println(kinds);
    }

}
/*
5 3
1 2 3 2 2
3
1 4
2 4
1 5
 */