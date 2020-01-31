package com.helius.executors;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义的线程池类
 * 成员变量：集合
 * 2：当前线程数量
 * 3.核心线程数
 * 4.最大线程数量
 * 5.任务队列的长度
 * 成员方法：提交任务，将任务添加到集合中，
 * 需要判断是否超出了任务总长度
 * 2.执行任务：判断当前线程的数量，决定是创建核心线程还是非核心线程
 *
 * @Author jcf
 * @Create 2020-01-27-16:08
 */
public class MyThreadPool {
    private List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());
    private int num;
    private int corePoolSize;
    private int maxSize;
    private int workerSize;

    public MyThreadPool(int corePoolSize, int maxSize, int workerSize) {
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.workerSize = workerSize;
    }

    //1.提交任务
    public void submit(Runnable r) {
        //判断：当前集合中任务的数量，是否超出了最大任务数量
        if (tasks.size() >= workerSize) {
            System.out.println("任务：" + r + "被丢弃了...");
        }else {
           tasks.add(r);
           execTask(r);
        }
    }
    //执行任务
    private void execTask(Runnable r) {
        //判断当前 线程池中的中线程总数量，是否超出了核心数，
        //
        if (num < corePoolSize) {
            new MyWorker("核心线程：" + num ,tasks).start();
            num++;
        } else if (num < maxSize) {
            new MyWorker("非核心线程：" + num, tasks).start();
        } else {
            System.out.println("线程：" +r+"被缓存了");
        }
    }
}
