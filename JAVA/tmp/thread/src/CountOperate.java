/*
 * @Author: ZHU Fangda
 * @Date: 2019-10-25 10:42:25
 * @LastEditTime: 2019-10-25 11:09:09
 * @LastEditors: Please set LastEditors
 * @Description: <<Java多线程核心技术>> P17页。改代码用于显示getName的特性
 *               Thread.currentThread().getName() 获取的是当前代码运行的线程。 
 *               需要注意的是， 如果代码所在的Thread类A通过另一个Thread类B构造函数传递给B，并借由B.start()运行， 
 * 那么此时 Thread.currentThread()返回的Thread是B，B只是执行了A.run中的代码。这也是this.getName()与Thread.currentThread().getName()同在run函数中但是输出不一致的原因所在。
 * @FilePath: \thread\CountOperate.java
 */

public class CountOperate extends Thread{

    public CountOperate(){
        System.out.println("Construction -- begin");
        System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().getName():" +this.getName());
        System.out.println("Construction -- end");
    }


    public void run(){
        System.out.println("Run -- begin");
        System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().getName():" +this.getName());
        System.out.println("Run -- end");
    }

    
    
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        c.setName("A");
        c.start();



    }
}



