/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-20 16:42:44
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-20 16:48:18
 * @Description: file content
 */
package com.zhufangda.exercise.thread.asq;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrierExample
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("After"));
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println("Waiting Number" + barrier.getNumberWaiting());
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }finally{
                    System.out.println("After " + barrier.getNumberWaiting());
                }
            });
        }

        executorService.shutdown();
    }
}
