package hashMap;

import java.util.HashMap;

/*
Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once.
The respective order of characters should remain same, as in the input string.
 */
public class ExtractUniqueCharacters {

    public static String uniqueChar(String str){
 
        StringBuilder result = new StringBuilder();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i=0;i<str.length(); i++){
            if(hashMap.get(str.charAt(i)) == null){
                result.append(str.charAt(i));
                hashMap.put(str.charAt(i),1);
            }
        }

        return result.toString();
    }
}
