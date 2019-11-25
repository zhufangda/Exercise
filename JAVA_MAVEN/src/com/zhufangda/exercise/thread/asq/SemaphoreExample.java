/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-20 16:51:03
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-20 17:05:20
 * @Description: file content
 */

package com.zhufangda.exercise.thread.asq;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(()->{
                try {
                    /**** 检查是否有剩余证书， 如果有继续执行，如果没有放弃。 */
                    /** semaphore只关心acquire执行了几次， release执行了几次， 不在意这些方法在哪里线程执行**/
                    semaphore.acquire();
                    semaphore.acquire();
                    System.out.println(Thread.currentThread() + " " + semaphore.availablePermits() + " ");

                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
