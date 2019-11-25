
/***
 * <java编程官方参看教程> page 245
 * @author Java: The Complete Reference, Ninth Edition
 */

public  class RunnableThreadDemo{
  public static void main(String[] args) {
    new RunnableThread();

    try{
      for(int i =0; i<5; i++){
        System.out.println("Main thread:" + i);
        Thread.sleep(1000);
      }
    }catch(InterruptedException e){
      System.out.println("Child interrupted!");
    }

      System.out.println("Existing main thread!");
  }
}




class RunnableThread implements Runnable{
  Thread t;

  public RunnableThread(){
    t = new Thread(this, "Demo Thread");  
  
    System.out.println("Child thread:" + t);

    t.start();
  }

  public void run(){
    try{
      for(int i=0; i<5; i++){
        System.out.println("Child Thread:" + i);
        Thread.sleep(2000);
      }
    }catch(InterruptedException e){
        System.out.println("Child thread interrupted!");
    }

    System.out.println("Existing child thread.");
  }

}