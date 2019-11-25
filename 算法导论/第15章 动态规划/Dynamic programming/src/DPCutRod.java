import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
 * @Author: ZHU Fangda
 * @Date: 2019-10-25 15:03:28
 * @LastEditTime: 2019-10-29 12:11:50
 * @LastEditors: Please set LastEditors
 * @Description: <<算法导论>> 15.1 钢条切割
 * @FilePath: \Dynamic programming\src\CutRod.java
 */
public class DPCutRod{
    // price for rod according to the rod length
    static int[] price = {1,5,8,9,10,17,17,20,24,30};
    static Map<Integer, Integer> memo;

    public static void main(String[] args) {

        int lenStart = 100, lenEnd=105;

        // for(int length=lenStart; length<=lenEnd; length++){
        //     long start = System.currentTimeMillis();
        //     int result = cutRod(length);
        //     double duration = (System.currentTimeMillis() - start)/10e3;
        //     System.out.printf("Recurcive Length:%d Result:%d Duration:%f s\n", length, result, duration);
        // }


        for(int length=lenStart; length<=lenEnd; length++){
            long start = System.nanoTime();
            int result = memoCutRod(length);
            long duration = System.nanoTime() - start;
            System.out.printf("DP1 Length:%d Result:%d Duration:%d ns\n", length, result, duration);


            start = System.nanoTime();
            result = bottomUpRod(length);
            duration = (System.nanoTime() - start);
            System.out.printf("DP2 Length:%d Result:%d Duration:%d ns\n", length, result, duration);
        }
        


    }
    

    /**
     * @description: 带备忘录的自下而上的动态规划算法 
     * @param {int} 钢条长度
     * @return: 指定钢条长度下的最大收益
     */
    private static int bottomUpRod(int length){
        int[] memo = new int[length];
        memo[0] = price[0];

        int maxVal = price[0];
        
        for(int i=1;i<length;i++){
            int bound = Math.min(i, price.length);
            maxVal = i<price.length?price[i]:Integer.MIN_VALUE;
            for(int j=0; j<bound;j++){
                maxVal = Math.max(maxVal, price[j] + memo[i-j-1]);
            }

            memo[i] = maxVal;

        }

        return maxVal; 

    }


    /**
     * @description: 带备忘录的自上而下动态规划算法 
     * @param {int} 钢条长度
     * @return: 指定钢条长度下的最大收益
     */
    static int memoCutRod(int length){
        int[] memo = new int[length];
        for(int i=0;i<length;i++){
            memo[i] = Integer.MIN_VALUE;
        }

        return memoCutRodAux(length, memo);
    }

    /**
     * 带备忘录的自上而下动态规划算法 
     * @param length 钢条长度
     * @param memo 备忘录，存储各个长度对应最优解
     * @return: 指定钢条长度下的最大收益
     */
    static int memoCutRodAux(int length, int[] memo){

    Scanner
        if(length == 0){
            return 0;
        }
        
        if(length == 1){
            return price[0];
        }
        int maxVal = length<=price.length? price[length-1] :Integer.MIN_VALUE;
        
        int bound = Math.min(price.length, length-1);

        for(int i=1; i<=bound; i++){

            if(memo[length-i-1] == Integer.MIN_VALUE){
                maxVal = Math.max(maxVal, price[i-1] + memoCutRodAux(length-i, memo));
            }else{
                maxVal = Math.max(maxVal, price[i-1] + memo[length-i-1]);
            }
        }

        memo[length-1] = maxVal;
        return maxVal;
    }

    /**
     * @description: 传统递归算法 
     * @param {int} 钢条长度
     * @return: 指定钢条长度下的最大收益
     */
    static int cutRod(int length){
        if(length == 0){
            return 0;
        }

        if(length == 1){
            return price[0];
        }


        int maxVal = Integer.MIN_VALUE;
        
        int bound = Math.min(price.length, length);

        for(int i=1; i<=bound; i++){
            maxVal = Math.max(maxVal, price[i-1] + cutRod(length-i));
        }

        return maxVal;

    }





}