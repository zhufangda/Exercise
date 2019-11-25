/*
 * @Author: ZHU Fangda
 * @Date: 2019-10-25 11:09:41
 * @LastEditTime: 2019-10-25 11:21:41
 * @LastEditors: Please set LastEditors
 * @Description: 学习如何停止Java线程
 * @FilePath: \thread\src\StopThread.java
 */
 public class StopThread {
    public static void main(String[] args) throws InterruptedException{
        Thread myThread = new MyThread();

        myThread.start();
        Thread.sleep(1000);
        myThread.interrupt();
        System.err.println("Interupting Thread ....");
    }
    
     
 }

class MyThread extends Thread{
    @Override
    public void run() {

        super.run();
        long start = System.currentTimeMillis();
        for(int i=0; i<10000;i++){
            System.out.println(i);
        }
    

        double duration = (System.currentTimeMillis() - start)/10e3;
        System.out.println("Using Time:" + duration + " seconds");
    }
    

 }
