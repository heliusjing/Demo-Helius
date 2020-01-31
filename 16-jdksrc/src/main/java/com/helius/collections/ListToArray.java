package com.helius.collections;

import java.util.ArrayList;

/**
 * @Author jcf
 * @Create 2020-01-22-21:18
 */
public class ListToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(2);
        list.add("hello");
        list.add("world");
        String[] array = list.toArray(new String[2]);
        System.out.println("array = " + array.toString());
    }
}
