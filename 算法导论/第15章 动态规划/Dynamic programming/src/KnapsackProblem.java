/*
 * @Author: ZHU Fangda
 * @Date: 2019-10-25 16:52:11
 * @LastEditTime: 2019-11-04 17:40:54
 * @LastEditors: Please set LastEditors
 * @Description: 背包9问 
 * @FilePath: \Dynamic programming\src\tempCodeRunnerFile.java
 */

import java.util.Scanner;

public class KnapsackProblem{
    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] v = {6, 3, 5, 4, 6};
        int m = 10;

        System.out.println(knapsack(w,v,m));

    }

    /** 01背包算法
     * @description: 
     * @param {type} 
     * @return: 
     */    
    /**
     * 01背包算法
     * @param weights 各物品重量
     * @param values 各物品价值
     * @param total 背包最大重量
     * @return 背包最大价值
     */
    public static int knapsack(int[] weights, int[] values, int total){
        /*** 物品数量 */
        int n = values.length; 
        /*** 备忘录， 第一个index为物品编号，第二个为重量 */
        int[] f = new int[total+1];
        
        /***初始化数组， 重量为0时，所有物品都放不进去，所以价值为0 */
        for(int j=0;j<=total;j++){
            f[j] = 0;
        }

        int weightBound = 0;
        for(int idx=1;idx<=n;idx++){
            int currentWeight = weights[idx-1];
            int currentValue = values[idx-1];
            weightBound += currentWeight;

            for(int j=total;j>=Math.max(total-weightBound, currentWeight);j--){
                f[j] = Math.max(f[j], f[j-currentWeight] + currentValue);


                
            }
        }

        // for(int idx=0;idx<=n;idx++){
        //     for(int j=0; j<=total;j++){
        //         System.out.printf("%5d ", f[idx][j]);
        //     }
        //     System.out.println();
        // }


        return f[total];


    }
}