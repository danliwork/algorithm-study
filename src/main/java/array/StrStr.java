package array;

public class StrStr {

    public static int strStr(String haystack, String needle) {
        int result = -1;
        if(haystack.length() < needle.length()){
            return -1;
        }
        if(needle.length() == 0) return 0;
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i) == (needle.charAt(0))){
                result = checkFromHere(haystack, needle, i);
            }
        }
        return result;
    }

    private static int checkFromHere(String haystack, String needle, int i){
        if(haystack.length()-i < needle.length()) return -1;
        int l1 = i;
        int l2 = 0;
        while(l1 < haystack.length() && l2<needle.length()){
            if(haystack.charAt(l1) != needle.charAt(l2))
                return -1;
            l1++;
            l2++;
        }
        return i;
    }


    public static void main(String[] args) {
        int x = strStr("hello" ,  "ll");
    }

}
