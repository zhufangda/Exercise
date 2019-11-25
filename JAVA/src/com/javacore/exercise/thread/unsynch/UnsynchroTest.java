/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-19 16:44:48
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-19 16:52:58
 * @Description: file content
 */


package com.javacore.exercise.thread.unsynch;

class UnsynchroTest {
    public static final int NACCOUNT = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;

    public static int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNT, INITIAL_BALANCE);

        for(int i=0;i<NACCOUNT;i++){
            int from = i;

            Runnable r = new Runnable(){
            
                @Override
                public void run() {
                    while(true){
                        int toAccount = (int)(bank.size()*Math.random());
                        
                        bank.transfer(from, toAccount, (int)(MAX_AMOUNT*Math.random()));
                    }
                }
            };

            new Thread(r).start();
        }

        
    }

    
}

