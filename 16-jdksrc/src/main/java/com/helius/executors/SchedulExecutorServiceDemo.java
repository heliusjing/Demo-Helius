package com.helius.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author jcf
 * @Create 2020-01-27-17:36
 */
public class SchedulExecutorServiceDemo {
    public static void main(String[] args) {
        //1.获取一个具备延迟执行任务的线程池对象
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        //2.创建多个任务对象，提交任务,每个任务延迟2秒执行
        ses.schedule(new MyRunnable(1),2, TimeUnit.SECONDS);
        System.out.println("over");
    }

}
class MyRunnable implements Runnable{
    private int id;

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("执行了任务 = " + name);
    }
}
