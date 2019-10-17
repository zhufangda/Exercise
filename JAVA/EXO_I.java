public class EXO_I{

    static private void copy(int[] fromArray, int fromStart, int fromEnd, int[] toArray, int toStart){
        for(int i=0; i<fromEnd-fromStart; i++){
            toArray[toStart+i]=fromArray[fromStart+i];
        }
    }

    public static int[] merge(int[] left, int[] right){
        
        int totalLength = left.length + right.length;
        int[] output = new int[totalLength];

        int leftIdx = 0;
        int rightIdx = 0;

        for(int i=0; i<=totalLength; i++){

            if(leftIdx==left.length){
                copy(right, rightIdx, right.length, output, i);
                return output;
            }else if(rightIdx==right.length){
                copy(left, leftIdx, left.length, output, i);
                return output;
            }

            
            int left_val = left[leftIdx];
            int right_val = right[rightIdx];


            if(left_val<right_val){
                output[i] = left_val;
                leftIdx++;
            }else{
                output[i] = right_val;
                rightIdx++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] input1= {2, 4, 6, 8 ,10};
        int[] input2= {1, 3, 5, 7, 9};
        
        int[] output = merge(input1, input2);


        for(Integer ele: output){
            System.out.printf("%d ", ele);
        }

    }
    
}
