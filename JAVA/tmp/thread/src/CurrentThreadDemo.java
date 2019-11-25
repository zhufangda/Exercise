/***
 * <java编程官方参看教程> page 243
 * @author Java: The Complete Reference, Ninth Edition
 */

 public class CurrentThreadDemo{

  public static void main(String[] args) {
    Thread t = Thread.currentThread();

    System.out.println("Before change:\t" + t);

    t.setName("My Thread");
    System.out.println("After change:\t" + t);

    try{
      for(int i=0; i<5; i++){
        System.out.println(i);
        Thread.sleep(1000);
      }
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }

 }