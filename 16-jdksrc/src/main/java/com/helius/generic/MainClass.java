package com.helius.generic;

import java.util.ArrayList;

/**
 * @Author jcf
 * @Create 2020-01-21-19:34
 */
public class MainClass {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("java");
        list.add(100);
        list.add(true);
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);//只能用Object类型去接收

        }
    }
}
