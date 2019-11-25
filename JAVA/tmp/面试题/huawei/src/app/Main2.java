import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {



    static class Recoder{
      String filename;
      int number;
      int order;
      int counter;

      Recoder(String filename, int number, int order){
        this.filename = filename;
        this.number = number;
        this.counter = 1;
        this.order = order;
      }

      String getName(){
        int size = this.filename.length();
        return size<=16 ? this.filename:this.filename.substring(size-16);

      }

      @Override
        public String toString() {
          
          return number + "-" + filename;
        }
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int total = 0;
    
        Map<String, Recoder> recoders = new HashMap<>();
        
        while(in.hasNext()){
            String[] input1 = in.nextLine().split(" ");
            String[] path = input1[0].split("\\\\");
            String fileName = path[path.length-1];
            int number = Integer.valueOf(input1[input1.length-1]);

            

            String key = number + "-" + fileName;

            if(recoders.containsKey(key)){
              recoders.get(key).counter++;
            }else{
              total++;
              recoders.put(key, new Recoder(fileName, number, total));
              
            }

        }

        recoders.values().stream()
          .sorted((a,b) -> a.counter==b.counter ? a.order-b.order:b.counter-a.counter).limit(8)
          .forEach(a->System.out.printf("%s %d %d\n", a.getName(), a.number, a.counter));

        
        
    }
        
    
}