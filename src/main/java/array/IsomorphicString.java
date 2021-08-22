package array;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static boolean isIsomorphic(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        if(lengthS != lengthT) return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<lengthS; i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(!map.containsKey(charS) && !map.containsKey(charT)){
                map.put(charS, charT);
            } else {
                if(charT != map.get(charS) || charS != map.get(charT)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean result = isIsomorphic("add", "egg");
    }
}
