import java.util.List;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * MergeSort
 */
public class MergeSort{


    static private void merge(List<Integer> array, int p, int q, int r){
        System.out.printf("p=%d q=%d r=%d\n", p, q, r);
        List<Integer> left = new ArrayList<Integer>(array.subList(p,q+1));
        List<Integer> right = new ArrayList<Integer>(array.subList(q+1, r+1));
        left.add(Integer.MAX_VALUE);
        right.add(Integer.MAX_VALUE);

        int left_idx = 0;
        int right_idx = 0;

        for(int i=p; i<=r; i++){

            int left_val = left.get(left_idx);
            int right_val = right.get(right_idx);
            
            System.out.printf("left_idx=%d right_idx=%d left_val=%d right_val=%d\n",left_idx, right_idx, left_val, right_val);

            if(left_val<right_val){
                array.set(i, left_val);
                left_idx++;
            }else{
                array.set(i, right_val);
                right_idx++;
            }
        }
    }

    static public void mergeSort(List<Integer> array, int p, int r){

        if(p>=r) return;

        System.out.printf("p=%d r=%d\n", p, r);
        int q=(p+r)/2;

        mergeSort(array, p, q);
        mergeSort(array, q+1, r);
        merge(array, p,q,r);
    }
    public static void main(String[] args) {
        List<Integer> input= Arrays.asList(5,4,98,2,22);

        mergeSort(input, 0, input.size()-1);


        for(Integer ele: input){
            System.out.printf("%d ", ele);
        }



    }
    

    
}