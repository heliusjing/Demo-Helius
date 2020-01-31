package com.helius.synchronizedDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author jcf
 * @Create 2020-01-25-10:06
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(() -> "返回个字符串");
        String result = future.get();
        System.out.println("result = " + result);

    }
}
