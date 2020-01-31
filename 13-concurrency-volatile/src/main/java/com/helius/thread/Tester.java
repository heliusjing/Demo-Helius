package com.helius.thread;

/**
 * @Author jcf
 * @Create 2020-01-21-21:24
 */
public class Tester {
    // 执行次数
/*    private static final long COUNT = 100000000;
    private static final StopWatch TIMER = new StopWatch();

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
        // 打印比较测试结果
        System.out.println(TIMER.prettyPrint());
    }

    private static void serial() {
        TIMER.start("串行执行" + COUNT + "条数据");

        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += 5;
        }
        // 串行执行
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }

        TIMER.stop();
    }

    private static void concurrency() throws InterruptedException {
        TIMER.start("并行执行" + COUNT + "条数据");

        // 通过匿名内部类来创建线程
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < COUNT; i++) {
                a += 5;
            }
        });
        thread.start();

        // 并行执行
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        // 等待线程结束
        thread.join();
        TIMER.stop();
    }*/
}
