/*
 * @Author: huawei 测试题
 * @Date: 2019-10-29 14:16:43
 * @LastEditTime: 2019-10-30 12:42:31
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Dynamic programming\src\Main.java
 */
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            try {
                String input = in.next();
                int output = solution(input);
                System.out.println(output);
            } catch (NumberFormatException e) {
                System.out.println("ERROR");
            }
        }

    }

    public static int charToNum(char input) {
        if (input >= '0' && input <= '9') {
            return input - '0';
        } else if (input >= 'a' && input <= 'z') {
            return input - 'a' + 10;
        } else if (input >= 'A' && input <= 'Z') {
            return input - 'A' + 36;
        } else if (input == '@') {
            return 62;
        } else if (input == '_') {
            return 63;
        } else {
            throw new NumberFormatException();
        }
    }

    public static int solution(String input) {
        String[] data = input.split("#");
        int base = 10;
        String uttrNum = null;

        if (data.length == 2) {
            base = Integer.valueOf(data[0]);
            if(base<2 && base>64){
                throw new NumberFormatException("Incorrect base " + base);
            }
            uttrNum = data[1];
        } else {
            String sufix = input.substring(0, 2);
            if (sufix.toLowerCase().equals("0x")) {
                base = 16;
                uttrNum = input.substring(2);
            } else if (sufix.charAt(0) == '0') {
                base = 8;
                uttrNum = input.substring(1);
            } else {
                base = 10;
                uttrNum = input;
            }
        }

        int sum = 0;
        for (int i = 0; i < uttrNum.length(); i++) {
            int digital = charToNum(uttrNum.charAt(i));
            if (digital >= base) {
                throw new NumberFormatException("Find digital " + digital + " for base " + base);
            }

            sum = sum * base + digital;
        }

        return sum;

    }
}
