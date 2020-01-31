package com.helius.synchronizedDemo;

public class SynTest01 implements Runnable{
    static int a=0;
    Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        SynTest01 syn= new SynTest01();
        Thread thread1 = new Thread(syn);
        Thread thread2 = new Thread(syn);
        thread1.start();thread1.join();
        thread2.start();thread2.join();
        System.out.println(a);
    }
    @Override
    public void run() {
        synchronized (object) {
            for(int i=0;i<1000;i++) {
                a++;
            }
        }//结束
    }
}