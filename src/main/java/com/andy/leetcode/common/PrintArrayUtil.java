package com.andy.leetcode.common;

/**
 * Created by andy on 2019/6/8.
 */
public class PrintArrayUtil {
    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
