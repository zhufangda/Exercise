
/*
 * @Author: your name
 * @Date: 2019-10-24 11:25:41
 * @LastEditTime: 2019-11-03 14:15:02
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \面试题\huawei\src\Main1.java
 */
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.text.DecimalFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000");
        
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            if(n==0){
                System.out.println(df.format(0.0));
                continue;
            }
            int x[] = new int[n];
            int y[] = new int[n];
            int a[] = new int[n];
            int b[] = new int[n];
            int v[] = new int[n];
            
            for(int i=0;i<n;i++){
                x[i] = in.nextInt();
                y[i] = in.nextInt();
                a[i] = in.nextInt();
                b[i] = in.nextInt();
                v[i] = in.nextInt();
            }
            
            double f = solution(n, x,y,a,b, v);
            
            System.out.println(df.format(f));
        }
    }


    public static double solution(int n, int[] x, int[] y, int[] a, int[] b, int[] v){
        double maxLen = 0;
        for(int i=0;i<n;i++){

            double len = Math.sqrt((a[i]-x[i])^2 +(b[i]-y[i])^2)/v[i];
            if(maxLen < len){
                 maxLen = len;
            }
        }
        
        return maxLen;
    }
}