/*
 * @Author: your name
 * @Date: 2019-11-04 17:42:10
 * @LastEditTime: 2019-11-04 18:23:23
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \heap\src\Heap.java
 */
public class Heap {
    private int[] A;
    private int size;
    public Heap(int[] A){
        this.A = A;
        this.size= A.length;
    } 



    public int left(int idx){
        return 2*idx+1;
    }

    
    public int right(int idx){
        return idx*2+2;
    }

    public void buildMaxHeap(){
        for(int i=size/2;i>=0;i--){
            maxHeapify(i);
        }

    }

    public void maxHeapify(int idx){
        int l = left(idx);
        int r = right(idx);
        int largest = 0;
        if(l<this.size && A[l]>A[idx]){
            largest = l;
        }else{
            largest = idx;
        }

        if(r<this.size && A[r]>A[largest]){
            largest = r;
        }

        if(largest != idx){
            int tmp = A[idx];
            A[idx] = A[largest];
            A[largest] = tmp;

            maxHeapify(largest);
        }


    }

    public void heapSort(){
        buildMaxHeap();
        this.size = A.length;
        for(int i=A.length-1;i>=1;i--){
            int tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;
            this.size--;
            maxHeapify(0);
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        
        for(int i: A){
            builder.append(i).append(",");
        }
        
        builder.append("]");
        
        return builder.toString();
    }


    public static void main(String[] args) throws Exception {
        
        /****** 6.2 堆性质的维护 p85 */
        // int A[] = {27, 17, 3, 16, 13 ,10, 1,5,7,12,4,8,9,0};
        // Heap heap = new Heap(A);
        // heap.maxHeapify(2);
        // System.out.println(heap);

        /****** 6.3 建堆 p87 */
        // int A[] = {4,1,3,2,16,9,10,14,8,7};
        // Heap heap = new Heap(A);
        // heap.buildMaxHeap();
        // System.out.println(heap);

        /****** 6.4 堆排序 p89 */
        int A[] = {4,1,3,2,16,9,10,14,8,7};
        Heap heap = new Heap(A);
        heap.heapSort();
        System.out.println(heap);
        

    }
}


