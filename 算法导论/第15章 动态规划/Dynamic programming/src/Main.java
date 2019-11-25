
/*
 * @Author: your name
 * @Date: 2019-10-29 14:16:43
 * @LastEditTime: 2019-10-31 14:22:57
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Dynamic programming\src\Main.java
 */
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        // Scanner in = new Scanner(System.in);
        // while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            
                String input = "[[tShirt],[doll], toy, apple]";
                List<List<String>> output = solution(input);


                for(int i=output.size()-1; i>=0; i--){
                    if(output.get(i).isEmpty()){
                        System.out.println("[]");
                        continue;
                    }
                String content =
                
                String.join(",", output.get(i));
                    System.out.println("[" + content + "]");

                }


        // }

    }


    public static List<List<String>> solution(String input) {
        Stack<Integer> stack = new Stack<>();
        String subStr = new String(input);
        
        List<List<String>> map= new ArrayList<>();

        while(!subStr.isEmpty()){
            if(subStr.charAt(0)=='['){
                stack.push(stack.isEmpty()?0:stack.peek()+1);
                subStr = subStr.substring(1);
                if(stack.peek() >= map.size()){
                    map.add(new ArrayList<String>());
                }
                
            }else if(subStr.charAt(0)==']') {
                stack.pop();
                subStr = subStr.substring(1);
            }else if(subStr.charAt(0)==','){
                subStr = subStr.substring(1);
                continue;
            }else{
                StringBuilder content =  new StringBuilder();
                
                int i = 0;
                for(i=0; i<subStr.length(); i++){
                    char letter = subStr.charAt(i);
                    if(letter=='[' || letter==']' || letter==','){
                        break;
                    }else{
                        content.append(letter);
                    }
                }
                if(stack.peek() >= map.size()){
                    map.add(new ArrayList<String>());
                }

                map.get(stack.peek()).add(content.toString().trim());
                subStr = subStr.substring(i);
            }
        }
        return map;
       
    }


}


