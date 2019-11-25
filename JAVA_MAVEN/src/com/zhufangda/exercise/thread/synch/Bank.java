/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-19 16:12:06
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2019-11-19 17:19:12
 * @Description: file content
 */

package com.zhufangda.exercise.thread.synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private Lock bankLock = new ReentrantLock();
    private double[] account;
    private Condition sufficientFund;


    public Bank(int n, double initalBalance) {
        account = new double[n];
        Arrays.fill(account, initalBalance);
        sufficientFund = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount){

        bankLock.lock();
        try{
            while(account[from]<amount){
                System.out.printf("%s\t Fund insufficient for %10.2f from %d to %d \n", Thread.currentThread(), amount, from, to);
                sufficientFund.await();
            }

            StringBuilder builder = new StringBuilder();

            builder.append(Thread.currentThread());
            account[from] -= amount;
            builder.append(String.format("\t%10.2f from %d to %d", amount, from,to));
            account[to] += amount;
            builder.append(String.format("\tTotal balance: %10.2f", getTotalBalance()));
            System.out.println(builder);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sufficientFund.signalAll();
            bankLock.unlock();
        }

    }

    public double getTotalBalance(){
        bankLock.lock();
        double sum = 0.0;
        try{
            sum = Arrays.stream(account).sum();
        }finally {
            bankLock.unlock();
        }
        return sum;
    }

    public int size(){
        return account.length;
    }
}
