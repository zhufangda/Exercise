/*
 * @Author: your name
 * @Date: 2019-11-15 15:35:20
 * @LastEditTime: 2019-11-15 15:39:44
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \heap\Solution2.java
 */
/*
*/

import java.io.*;
import java.util.*;
import java.util.Arrays;


public class Solution2 {
  public static void main(String[] args) {
    int[] a = {3, 6, 9, 10, 10, 17, 20};
    int[] b = {1, 9, 10, 11, 17, 20, 24, 24, 27};
    
    
    List<Integer> ans = intersection(a,b);
    System.out.println(ans);
    
    
  }
  
  /*
  input1: [3, 6, 9, 10, 10, 17, 20 .... ] 1 Tb
  input2: [1, 9, 10, 11, 17, 20, 24, 24, 27 ...] 2 Tb
  
  => output: 1 Tb
  */
  
  static public List<Integer> intersection(int[] a, int[] b){
      List<Integer> ans = new ArrayList<Integer>();

      int i=0; 
      int j=0;
      while(i<a.length && j<a.length){
        if(a[i]<b[j]){
            i++;
        }else if(a[i]>b[j]){
            j++;
        }else{
            ans.add(a[i]);
            i++;
            j++;
        }

      }


      return ans;
  }

    
}
  