package com.helius.volatileTest;

/**
 * 饿汉：静态代码块
 * @Author jcf
 * @Create 2020-01-18-14:35
 */
public class Singleton02 {

    private static final Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        return INSTANCE;
    }
}
