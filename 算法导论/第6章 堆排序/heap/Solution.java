/*
 * @Author: ZHU Fangda
 * @Date: 2019-11-15 15:13:40
 * @LastEditTime: 2019-11-15 15:33:41
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \heap\Solution.java
 */
public class Solution1{


    public static void main(String[] args) {
            int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
            // Random random = new Random();
            // int w = 3;

            // for(int i=0;i<100;i++){
            //     input[i] = random.nextInt();
            // }
            int w = 3;
            double[] res = slideAverage(input, w);
            for(double ele: res){
                System.out.printf(" " + ele);
            }
    }

    public static double[] slideAverage(int[] input, int w){
        double[] output = new double[input.length - w+1];
        
        double sum = 0;
        for(int i=0;i<w;i++){
            sum += input[i];
        }
        
        output[0] = sum / w; 
        
        for(int i=1;i<input.length-w+1;i++){
            sum -= input[i-1];
            sum += input[w+i-1];
            output[i] = sum/w;
        }

        return output;
    }

}