import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
/*
 * @Author: your name
 * @Date: 2019-11-11 21:19:23
 * @LastEditTime: 2019-11-19 09:54:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \JAVA\src\com\javacore\exercise\Main.java
 */
/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/


public class Main {
public static void main( final String[] argv ) throws Exception {
		final String  line;
		final Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			
			List<List<Integer>> memo = new ArrayList<>();
			
			for(int i=0;i<n;i++){
                List<Integer> pair = new ArrayList<>();
			    pair.add(sc.nextInt());
			    pair.add(sc.nextInt());
			    memo.add(pair);

			}

			
            Collections.sort(memo, (o1,o2)->o1.get(0)-o2.get(0));
            
            Map<Object, List<Integer>> map = memo.stream().collect(Collectors.toMap(T->T.get(0), Function.identity()));
            
            int currNbr = 0;
            int currPtr = 0;

            while(){
                while(currNbr==currPtr){
                     
                }


            }

            for(int i=0;i<n;i++){

            }
			
			
			
			
			/* Lisez les données et effectuez votre traitement */
		}
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}
}