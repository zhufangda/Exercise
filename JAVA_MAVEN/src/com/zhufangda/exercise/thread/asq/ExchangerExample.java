/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-20 17:07:21
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-20 17:38:35
 * @Description: file content
 */
package com.zhufangda.exercise.thread.asq;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExchangerExample
 */
public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExecutorService eService = Executors.newCachedThreadPool();

        // 每次运行exhange方法，线程会阻塞， 知道有别的线程运行exchange并交换数据。 换句话说如果有单数个线程交换数据， 会有线程数据落单但被一直阻塞。
        // 同步队列与exchange相似，但是数据只会单向传播
        for (int i = 0; i < 9; i++) {
            eService.execute(() -> {
                try {


                    String data = Thread.currentThread().getName();
                    // Thread.sleep(1000);
                    data = exchanger.exchange(data);
                    System.out.printf("%s get %s\n", Thread.currentThread(), data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });


        }
        eService.shutdown();
    }

}
