/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-19 16:44:48
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-19 17:12:06
 * @Description: file content
 */


package com.zhufangda.exercise.thread.synch;


public class SynchTest {
    public static final int NACCOUNT = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;

    public static int DELAY = 100;

    public static void main(final String[] args) {
        final Bank bank = new Bank(NACCOUNT, INITIAL_BALANCE);

        for(int i=0;i<NACCOUNT;i++){
            int from = i;

            Runnable r = new Runnable(){

                @Override
                public void run() {
                    while(true){

                        int fromAccount = (int)(bank.size()*Math.random());
                        int toAccount = 0;

                        do{
                            toAccount = (int)(bank.size()*Math.random());
                        }while(fromAccount != toAccount);

                        bank.transfer(from, toAccount, (int)(MAX_AMOUNT*Math.random()));
                        try{
                            Thread.sleep((int)(DELAY*Math.random()));
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }

                    }
                }
            };

            new Thread(r).start();
        }


    }


}

