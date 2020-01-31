package com.helius.synchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Author jcf
 * @Create 2020-01-25-9:50
 */
public class DeadLockTest {
    private static String a="a";
    private static  String b ="b";
    public static void main(String[] args) {
        deadLock();
    }
    public static void deadLock() {
        new Thread(() -> {
            synchronized (a) {
                System.out.println("a对象被锁住");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("b对象被锁住");
                }
            }
        },"Thread-A").start();
        new Thread(() -> {
            synchronized (b) {
                System.out.println("b对象被锁住");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("a对象被锁住");
                }
            }
        },"Thread-B").start();
    }
}
