/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-19 16:12:06
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-19 17:01:28
 * @Description: file content
 */

package com.javacore.exercise.thread.unsynch;

import java.util.Arrays;

public class Bank {

    private double[] account;


    public Bank(int n, double initalBalance) {
        account = new double[n];
        Arrays.fill(account, initalBalance);
    }

    public void transfer(int from, int to, double amount){
        if(account[from]<amount){
            System.err.printf("Fail to transfer amount %f from %d to %d");
            return;
        }

        StringBuilder builder = new StringBuilder();

        builder.append(Thread.currentThread());
        account[from] -= amount;
        builder.append(String.format(" %10.2 from %d to %d", amount, from,to));
        account[from] += amount;
        builder.append(String.format(" Total balance: %10.2", getTotalBalance()));
        System.out.println(builder);
    }

    public double getTotalBalance(){
        return Arrays.stream(account).sum();
    }

    public int size(){
        return account.length;
    }
}
