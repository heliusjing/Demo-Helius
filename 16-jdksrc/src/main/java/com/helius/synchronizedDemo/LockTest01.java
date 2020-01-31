package com.helius.synchronizedDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author jcf
 * @Create 2020-01-24-23:06
 */
public class LockTest01 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> doSome(lock),"thread1").start();
        new Thread(() -> doSome(lock),"thread2").start();
    }

    private static void doSome(Lock lock) {
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }
}
