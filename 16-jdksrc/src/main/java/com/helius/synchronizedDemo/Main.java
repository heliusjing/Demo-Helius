package com.helius.synchronizedDemo;

import java.util.concurrent.*;

/**
 * @Author jcf
 * @Create 2020-01-24-21:45
 */
public class Main implements Callable<String> {


    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        String str = "我是带返回值的子线程";
        return str;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService newCacheThreadPool = Executors.newCachedThreadPool();
        Future<String> future = newCacheThreadPool.submit(new Main());
        if(!future.isDone()) {
            System.out.println("线程尚未执行结束");
        }
        System.out.println("等待中");
        Thread.sleep(300);
        System.out.println(future.get());
        newCacheThreadPool.shutdown();
    }

/*    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        String str = "我是带返回值的子线程";
        return str;
    }
    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<String>(new Main());
        new Thread(task).start();
        try {
            if(!task.isDone()) {
                System.out.println("任务没有执行完成");
            }
            System.out.println("等待中...");
            Thread.sleep(3000);
            System.out.println(task.get());

        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
}
