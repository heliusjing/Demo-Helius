package com.heilus.jdksrc;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author jcf
 * @Create 2020-01-16-22:16
 */
public class arrayListTest {

    @Test
    public void test01() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("J");
        list.add("K");
        list.add("L");
        list.add("M");
        list.add("N");
        String ele = list.get(0);
        System.out.println("s = " + ele);
    }
}
