import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Map<String, Integer> map = new HashMap<>();

    static{
      map.put("3", 0);
      map.put("4", 1);
      map.put("5", 2);
      map.put("6", 3);
      map.put("7", 4);
      map.put("8", 5);
      map.put("9", 6);
      map.put("10", 7);
      map.put("J", 8);
      map.put("Q", 9);
      map.put("K", 10);
      map.put("A", 11);
      map.put("2", 12);
      map.put("joker", 13);
      map.put("JOKER", 14);

    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int total = 0;
    
        
        while(in.hasNext()){
            String[] input = in.nextLine().split("-");
            String[] cards1 = input[0].split(" ");
            String[] cards2 = input[1].split(" "); 




            int result =  solution(cards1, cards2);

            if(result>0){
              System.out.println(input[0]);
            }else if(result<0){
              System.out.println(input[1]);
            }else{
              System.out.println("ERROR");
            }

        }

        
    }
        
    
    static int solution(String[] cards1, String[] cards2){
      
      if(cards1[0].equals("joker") && cards1[1].equals("JOKER")){
        return 1;
      }
      
      if(cards2[0].equals("joker") && cards2[1].equals("JOKER")){
        return -1;
      }

      if(cards1.length == 4 && cards2.length !=4){
        return 1;
      }

      if(cards2.length == 4 && cards1.length != 4){
        return -1;
      }

      if(cards1.length != cards2.length){
        return 0;
      }

      return map.get(cards1[0])-map.get(cards2[0]);


    }

     
}