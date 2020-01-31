package com.helius.volatileTest;

/**
 * 饿汉式
 * 线程不安全
 * @Author jcf
 * @Create 2020-01-18-14:37
 */
public class Singleton03 {

    private static  Singleton03 INSTANCE;

    private Singleton03() {
    }

    //线程不安全
    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
            //可能有多个线程同时执行到，但没有执行下一步
            //严格上有线程安全问题，那样就不是单例了
            //不推荐使用
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }
}
