package com.zhufangda.exercise.thread.asq;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-20 16:24:11
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-20 16:39:29
 * @Description: file content
 */
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {

                @Override
                public void run() {

                    try {
                        System.out.printf("%s %d\n", Thread.currentThread(), countDownLatch.getCount());
                        countDownLatch.countDown();

                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

        countDownLatch.await();
        System.out.printf("%s %d\n", Thread.currentThread(), countDownLatch.getCount());
        executor.shutdown();



    }

}
