/*
 * @Author: your name
 * @Date: 2019-10-31 14:23:41
 * @LastEditTime: 2019-10-31 14:30:27
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Dynamic programming\src\LCSLength.java
 */
/**
 * LCSLength
 */
public class LCSLength {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] c = new int[text1.length()+1][text2.length()+1];
        
        char x = 0,y=0;
        for(int i=0;i<=text1.length();i++){
            for(int j=0;j<=text2.length(); j++){
                x = text1.charAt(i-1);
                y = text1.charAt(j-1);

                if(i==0 || j==0){
                    c[i][j] = 0;
                }

                if(x==y){
                    c[i][j] = c[i][j] +1;
                    continue;
                }else{
                    c[i][j] = Math.min(c[i][j-1], c[i-1][j]);
                }


            }
        }

        return c[text1.length()][text2.length()];
        
    }
}