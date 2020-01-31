package com.helius.volatileTest;

/**
 *演示线程的不可见性
 * 解决方法：volatile关键字
 * @Author jcf
 * @Create 2020-01-17-19:11
 */
public class VisibilityDemo01 {
    //main方法，主线程
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        while (true) {
            if (t.isFlag()) {
                System.out.println("主线程进入循环执行");
            }
        }
    }
}

class MyThread extends Thread {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
