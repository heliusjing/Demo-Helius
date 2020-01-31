package com.helius.volatileTest;

/**
 * 饿汉式
 * 线程不安全
 * @Author jcf
 * @Create 2020-01-18-14:37
 */
public class Singleton04 {

    private static Singleton04 INSTANCE;

    private Singleton04() {
    }

    //线程安全：锁机制
    //但性能较差：并发下只能有一个线程进程
    // synchronized：线程之间的互斥性
    public synchronized static Singleton04 getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Singleton04();
            }
        return INSTANCE;
    }
}
