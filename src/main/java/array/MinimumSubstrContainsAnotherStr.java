package array;

public class MinimumSubstrContainsAnotherStr {
    // Add any helper functions you may need here
    boolean containsAll(int[] window, int[] tChar){
        for(int i = 0; i<tChar.length; i++){
            if(tChar[i] != window[i]) {
                return false;
            }
        }
        return true;
    }

    int minLengthSubstring(String s, String t) {
        // Write your code here
        if(s == null) return -1;
        //window
        int l = 0, r = 0;
        int[] window = new int['z' - 'A' + 1];
        int[] tChar = new int['z' - 'A' + 1];
        for(char c : t.toCharArray()){
            tChar[c-'A'] ++;
        }
        //sliding window
        int res = Integer.MAX_VALUE;
        while(r < s.length()){
            window[s.charAt(r)-'A'] ++;
            r++;

            while(containsAll(window, tChar)){
                window[s.charAt(l)-'A']--;
                l++;
                res = Math.min(res, r - l +1);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        new MinimumSubstrContainsAnotherStr().minLengthSubstring("dcbefebce","fd");
    }
}
