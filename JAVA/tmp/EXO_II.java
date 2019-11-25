import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EXO_II {

    public static void main(String[] args) {
        // String filePath = "corejava10/gutenberg/crsto10.txt";
        
        String filePath = "crsto10.txt";

        try{
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String contents = new String(bytes, StandardCharsets.UTF_8);
            String[] words = contents.split("\\PL+");
            Collection<Set<String>> result = solution(words);
            
            result.stream().sorted( (x,y) -> y.size()-x.size() ).filter(x->x.size()>1).map(ele->Arrays.toString(ele.toArray())).forEach(System.out::println);

        }catch(IOException e){
            e.printStackTrace();
        }
        

    }

    private static Collection<Set<String>> solution(String[] wordList) {
        Map<String, Set<String>> output = new HashMap<>();
        
        for(String word: wordList){
            word = word.toLowerCase();
            String key = sortStr(word);
            if(!output.containsKey(key)){
                output.put(key, new HashSet<>());
            }

            output.get(key).add(word);
        }

        return output.values();
        
    }

    /**
     * Return a sorted string
     * @param input original string
     * @return a sorted string  
     */

    private static String sortStr(String input){
        return input.chars().sorted().collect(StringBuilder::new,
        StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    }
    
}
