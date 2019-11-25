
/***
 * <java编程官方参看教程> page 245
 * @author Java: The Complete Reference, Ninth Edition
 */

public  class MultiThreadDemo{
  public static void main(String[] args) {
    new RunnableThread("One");
    new RunnableThread("Two");
    new RunnableThread("Three");

    try{
      for(int i =0; i<5; i++){
        System.out.println("Main thread:" + i);
        Thread.sleep(100);
      }
    }catch(InterruptedException e){
      System.out.println("Child interrupted!");
    }

      System.out.println("Existing main thread!");
  }
}


class RunnableThread implements Runnable{
  private Thread t;
  private String name;

  public RunnableThread(String name){
    this.name = name;
    t = new Thread(this, name);  
  
    System.out.println("Create thread:" + t);

    t.start();
  }

  public void run(){
    try{
      for(int i=0; i<5; i++){
        System.out.println(name + " Thread:" + i);
        Thread.sleep(200);
      }
    }catch(InterruptedException e){
        System.out.println(name + " thread interrupted!");
    }

    System.out.println("Existing " + name + " thread.");
  }
}

