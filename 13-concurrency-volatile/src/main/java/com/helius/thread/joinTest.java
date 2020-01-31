package com.helius.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author jcf
 * @Create 2020-01-21-22:01
 */

public class joinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate. ");
    }

    //静态内部类
    static class Domino implements Runnable {

        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException ignore) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate. ");
        }
    }

}
