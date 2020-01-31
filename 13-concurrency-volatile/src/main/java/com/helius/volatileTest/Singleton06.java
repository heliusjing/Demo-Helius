package com.helius.volatileTest;

/**
 * 饿汉式
 * 双重检查机制+volatile修饰
 *
 * @Author jcf
 * @Create 2020-01-18-14:37
 */
public class Singleton06 {
    //保证可见性和禁止指令重排序
    private static volatile Singleton06 INSTANCE;

    private Singleton06() {
    }

    //线程不安全
    public static Singleton06 getInstance() {
        if (INSTANCE == null) {
            //多个线程同时进入a、b、c
            synchronized (Singleton06.class) {
                // 有锁，a进来了创建对象
                // b也进来了， 此时instance已创建了，发现instance不为空了
                //要想b线程知道instance不为空，就要保证这INSTANCE这个共享变量
                //对其他线程可见,就需要volatile保证可见性，禁止重排序
                if (INSTANCE == null) {
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }
}
