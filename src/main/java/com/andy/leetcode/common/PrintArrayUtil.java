package com.andy.leetcode.common;

/**
 * Created by andy on 2019/6/8.
 */
public class PrintArrayUtil {
    public static void print(char[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                if (j != 0) {
                    System.out.print(", ");
                }
                System.out.print(arr[i][j]);
            }
            System.out.print("]");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void print(int[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.println(", ");
            }
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                if (j != 0) {
                    System.out.print(", ");
                }
                System.out.print(arr[i][j]);
            }
            System.out.print("]");
        }
        System.out.println("]");
    }
}
