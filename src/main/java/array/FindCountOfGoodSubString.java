package array;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;


@Slf4j
class FindCountOfGoodSubString {
    public int countGoodSubstrings(String s) {
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int count = 0 ;
        while(right < s.length()){
            while(right-left <= 2 && !set.contains(s.charAt(right)) && right < s.length()){
                set.add(s.charAt(right));
                right++;
            }
            // size > 3 OR found duplicate
            if(right-left > 2){
                count++;
            }

            while(right-left > 2 || set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int res = new FindCountOfGoodSubString().countGoodSubstrings("xyzzaz");
        log.info("res=" + res);
    }
}