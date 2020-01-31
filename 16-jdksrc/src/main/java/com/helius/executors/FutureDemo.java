package com.helius.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author jcf
 * @Create 2020-01-27-17:49
 */
public class FutureDemo {
    public static void main(String[] args) {
        //1:获取线程池对象
        ExecutorService service = Executors.newCachedThreadPool();
        //2.创建Callable类型的任务对象
        Future<String> submit = service.submit(() -> {
            return "hello world";
        });
        boolean done = submit.isDone();
        System.out.println("done = " + done);
        boolean cancelled = submit.isCancelled();
        System.out.println("cancelled = " + cancelled);
        try {
            String s = submit.get();//一直阻塞，等待任务执行完成
            System.out.println("s = " + s);
            boolean done1 = submit.isDone();
            System.out.println("done1 = " + done1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
