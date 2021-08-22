package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int max = 0;
        //1. define window: left, right, container
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();

        //2. start sliding
        while (l < s.length() && r < s.length()) {
            char c = s.charAt(r);
            //start keep sliding right until INVALID condition meet
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(max, set.size());
                r++;
            }

            while (set.contains(c)) {
                //keep sliding left until right is VALID
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return "";
        }

        //define window
        int l = 0;
        int r = 0;
        Map<Character, Integer> map = new HashMap<>();

        //define result
        String res = "";

        //start sling
        while (l < s.length() && r < s.length()) {
            add(map, s.charAt(r));
            r++;
            while (containsAll(map, t)) {
                String substr = s.substring(l, r);
                res = res == "" || substr.length() < res.length() ? substr : res;
                remove(map, s.charAt(l));
                l++;
            }
        }

        return res;
    }

    private void add(Map<Character, Integer> map, char c){
        if(map.get(c) == null){
            map.put(c, 1);
        } else {
            map.put(c, map.get(c) + 1);
        }
    }

    private void remove(Map<Character, Integer> map, char c){
        map.put(c, map.get(c) - 1);
    }


    private boolean containsAll(Map<Character, Integer> map, String t){
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            add(tMap,c);
        }
        for(char c : t.toCharArray()){
            if(map.get(c) == null || map.get(c) == 0 || map.get(c) < tMap.get(c) )return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().minWindow("ADOBECODEBANC", "ABC");
    }
}
