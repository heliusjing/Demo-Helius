package com.helius.thread;

/**
 * @Author jcf
 * @Create 2020-01-21-21:21
 */
public class MyThread {
    // 播放音乐的线程类
    static class PlayMusicThread extends Thread {

        // 播放时间，用循环来模拟播放的过程
        private int playTime = 50;

        public void run() {
            for (int i = 0; i < playTime; i++) {
                System.out.println("播放音乐" + i);
            }
        }
    }

    // 方式1：继承 Thread 类
    public static void main(String[] args) {
        // 主线程：运行游戏
        for (int i = 0; i < 50; i++) {
            System.out.println("打游戏" + i);
            if (i == 10) {
                // 创建播放音乐线程
                PlayMusicThread musicThread = new PlayMusicThread();
                musicThread.start();
            }
        }
    }
}
