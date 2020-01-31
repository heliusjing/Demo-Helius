package com.helius.synchronizedDemo;

public class Waiter implements Runnable {

    private Message msg;

    public Waiter(Message m) {
        this.msg = m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name + " waiting to get notified at time:" + System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " 获取到msg的消息信息了:" + System.currentTimeMillis());
            //打印消息内容
            System.out.println(name + " processed: " + msg.getMsg());
        }
    }

}