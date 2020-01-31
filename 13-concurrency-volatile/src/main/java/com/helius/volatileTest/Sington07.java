package com.helius.volatileTest;

/**
 * 单例：静态内部类
 * jvm类加载只会初始化一次
 * 类的初始化实现延迟加载和线程安全的单例设计
 *
 * @Author jcf
 * @Create 2020-01-18-19:11
 */
public class Sington07 {
    private Sington07() {

    }
    private static class Inner{
        private static final Sington07 INSTANCE = new Sington07();
    }
    //静态内部类是在被调用时才会被加载，这种方案实现
    //  了懒汉单例的一种思想，需要用到的时候才去创建单例
    // 加上JVM的特性，类加载时会初始化一次
    //只会加载一次
    //延迟加载
    public static Sington07 getInstance() {
        return Inner.INSTANCE;
    }
}
