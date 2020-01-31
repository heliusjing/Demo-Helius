package com.helius.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors的静态方法生成线程池
 * @Author jcf
 * @Create 2020-01-27-17:04
 */
public class MyTest01 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

/*        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            System.out.println(Thread.currentThread().getName()+"执行了任务...");
            System.out.println("我是任务，我被执行了");
        });*/
    }
}


