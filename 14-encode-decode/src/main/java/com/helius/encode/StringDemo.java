package com.helius.encode;

import java.util.Arrays;

/**
 * @Author jcf
 * @Create 2020-01-21-9:18
 */
public class StringDemo {
    public static void main(String[] args) {
        String str = "黑马";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
    }
}
