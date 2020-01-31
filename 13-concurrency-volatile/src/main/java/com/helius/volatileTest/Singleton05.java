package com.helius.volatileTest;

/**
 * 饿汉式
 * 线程不安全,不推荐
 * @Author jcf
 * @Create 2020-01-18-14:37
 */
public class Singleton05 {

    private static Singleton05 INSTANCE;

    private Singleton05() {
    }

    //线程不安全
    public static Singleton05 getInstance() {
        if (INSTANCE == null) {
            //多个线程进入这里,但不能保证第一次获取对象的线程安全
            //性能得到了提高
            synchronized (Singleton05.class) {
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }
}
