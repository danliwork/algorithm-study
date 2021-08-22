package array;

public class StringSolutions {
    public static String countAndSay(int n) {
        String start = "1";
        if(n==1) return start;

        for(int i=2; i<=n; i++){
            start = getCountSayFromString(start);
        }
        return start;
    }

    private static String getCountSayFromString(String input){
        char[] chars = input.toCharArray();
        String output = "";
        int count = 0;
        for(int j=0; j < chars.length; j++){
            count ++;
            if(j == chars.length-1 || chars[j+1]!=chars[j]){
                output+=count;
                output+=chars[j];
                count = 0;
            }
        }
        return output;
    }

    private void writeCount(char[] chars, int anchor, int read, int write){
        if (read > anchor) {
            for (char c : ("" + (read - anchor + 1)).toCharArray())
                chars[write++] = c;
        }

    }

    public static void main(String [] args){
        String out = countAndSay(3);
        System.out.println(out);
    }
}
