import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*** 
 * program list 1-1 steams/CountLongWords.java 
 * @author JAVA Core II
 * **/

 public class CountLongWords{
    public static void main(String[] args) {
        // Convert string to path
        Path path = Paths.get("../corejava10/gutenberg/crsto10.txt");
        // Read all bytes in a file
        
        byte[] bytes;
        try{

            bytes = Files.readAllBytes(path);
                    // Decoding a array of bytes to String by a specified Charset. 
            String contents = new String(bytes, StandardCharsets.UTF_8);
            List<String> words = Arrays.asList(contents.split("\\PL+"));

            
            long count = 0;

            long beginTime = System.nanoTime();
            double duration;
                
            for(String word: words){
                if (word.length() >12) count++;

            }
            duration = (System.nanoTime()-beginTime)/1e6;
            System.out.printf("Loop - Count: %d Time: %f ms Time: %f ms\n", count, duration, (System.nanoTime()-beginTime)/1e6);
    
            beginTime = System.nanoTime();
            count = words.parallelStream().filter(word->word.length()>12).count();
            duration = (System.nanoTime()-beginTime)/1e6;
            System.out.printf("paralelSteams - Count: %d Time: %f ms Time: %f ms \n", count, duration, (System.nanoTime()-beginTime)/1E6);

            beginTime = System.nanoTime();
            count = words.stream().filter(word->word.length()>12).count();
            duration = (System.nanoTime()-beginTime)/1e6;
            System.out.printf("Steams - Count: %d Time: %f ms Time: %f ms\n", count,duration, (System.nanoTime()-beginTime)/1E6);
            
            Stream.iterate(seed, next)

        }catch(IOException e){
            System.out.println(e.getStackTrace());
            System.out.println(e.getSuppressed());
        }
        

        

       

    }
 }