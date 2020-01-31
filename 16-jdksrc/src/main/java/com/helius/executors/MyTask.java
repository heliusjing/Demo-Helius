package com.helius.executors;

/**
 * 自定义线程池
 * 这是任务类
 * 包含任务编号,每一个任务执行时间为0.2秒
 * @Author jcf
 * @Create 2020-01-27-16:09
 */
public class MyTask implements Runnable {
    private int id;
    //由于run方法是重写接口中的方法，因此id属性的初始化利用构造方法完成

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("线程：" + name + "即将执行任务：" + id);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + name + "即将完成任务：" + id);

    }
}
