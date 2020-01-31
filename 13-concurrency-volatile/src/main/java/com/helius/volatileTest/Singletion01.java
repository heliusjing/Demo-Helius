package com.helius.volatileTest;

/**
 * 单例：饿汉式
 * @Author jcf
 * @Create 2020-01-18-14:30
 */
public class Singletion01 {
    private static final Singletion01 INSTANCE = new Singletion01();

    private Singletion01() {
    }

    public static Singletion01 getInstance() {
        return INSTANCE;
    }

}
