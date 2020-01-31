package com.helius.HashMapDemo;

import java.util.HashMap;

/**
 * @Author jcf
 * @Create 2020-01-21-12:36
 *
 *         //当创建hashmap集合对象的时候，在jdk8前，构造方法中创建一个长度是16的Entry[]  table用来存储
 *         //对象数据的，在jdk8以后不是在HaspMap的构造方法底层创建数组了，是在第一次调用put方法时创建数组
 *         // Node[] table用来存储键值对数据的
 *         2.存数据，先调hashcode得到hashcode值，hashcode采用一种算法找到在数组中的槽位，如果这个槽位没数据
 *         直接存，如果有，就是根据equals方法看看是不是相等，不相等，就变成链表寸，如果table长度>64，槽位链表大于8就变成红黑树
 *         3.面试题：hash表是如何根据hashcode进行hash找到数组位置的（槽位）
 *          4.关键字：拉链法
 *
 */
public class HashMapTest01 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("孙悟空",520);
        hashMap.put("天蓬元帅",4000);
        hashMap.put("牛文鞭",40);
        hashMap.put("刘德华",56);


    }
}
