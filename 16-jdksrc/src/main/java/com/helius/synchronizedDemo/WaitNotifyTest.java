package com.helius.synchronizedDemo;

public class WaitNotifyTest {

    public static void main(String[] args) {
        Message msg1 = new Message("process1 it");
        Waiter waiter = new Waiter(msg1);
        new Thread(waiter, "waiter").start();

        Waiter waiter1 = new Waiter(msg1);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(msg1);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
    }

}