/*
 * @Author: ZHU Fangda 
 * @Date: 2019-10-28 15:16:44
 * @LastEditTime: 2019-10-28 18:00:46
 * @LastEditors: Please set LastEditors
 * @Description: 动态规划， 举证链乘法顺序动态规划问题。
 * @FilePath: \Dynamic programming\src\DPMaxtrixChainOrder.java
 */
public class DPMaxtrixChainOrder {
    static int[][] matrixDim = {{30,35}, {35, 15}, {15,5}, {5,10},{10,20},{20,25}};
    static int[][] memo = null;
    static int[][] sln = null;
    
    static int matrixChainOrder(int startIndex, int endIndex){
        int nbMatrix = endIndex-startIndex + 1;
        if(nbMatrix == 1){
            return 0;
        }else if(nbMatrix == 2){
            return matrixDim[startIndex][0] * matrixDim[startIndex][1] * matrixDim[endIndex][1];
        }

        int minValue= Integer.MAX_VALUE;
        for(int i=startIndex; i<endIndex; i++){
            System.out.printf("Start:%d i:%d end:%d\n", startIndex, i, endIndex);
            minValue = Math.min(minValue, matrixChainOrder(startIndex, i) + matrixChainOrder(i+1, endIndex) + matrixDim[startIndex][0] * matrixDim[i][1] * matrixDim[endIndex][1]);
        }

        return minValue;
    }


    public static void main(String[] args) {
        int value = matrixChainOrder(0, 5)  ;    
        System.out.println("Original Result:\t" + value);

        value = bottomUpMat();
        System.out.println("bottomUp Result:\t" + value);
        System.out.println("Memo:");
        for(int i=0; i<6; i++){
            for(int j=0; j<6;j++){
                System.out.printf("%d\t", memo[i][j]);
            }
            System.out.println();
        }
        System.out.println("Sln:");
        for(int i=0; i<6; i++){
            for(int j=0; j<6;j++){
                System.out.printf("%d\t", sln[i][j]);
            }
            System.out.println();
        }

    }


    public static int bottomUpMat(){
        memo = new int[matrixDim.length][matrixDim.length];
        sln = new int[matrixDim.length][matrixDim.length];
        for(int i =0; i<matrixDim.length; i++){
            memo[i][i] = 0;
        }

        
        for(int l=2;l<=matrixDim.length;l++){
            for(int i=0;i<matrixDim.length-l+1;i++){
                int j=i+l-1;
                memo[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j;k++){
                    int q = memo[i][k]+memo[k+1][j]+matrixDim[i][0] * matrixDim[k][1] * matrixDim[j][1];

                    if(q<memo[i][j]){
                        memo[i][j] = q;
                        sln[i][j] = k+1;
                    }
                }
            }
        }

        return memo[0][5];
        
        
    }
    
}