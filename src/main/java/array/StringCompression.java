package array;

public class StringCompression {
    public int compress(char[] chars) {
        //edge cases
        if(chars == null || chars.length ==0) return 0;
        if(chars.length == 1) return 1;// signle char
        //main
        int i=0;
        int j = 0;
        while(j < chars.length && i<chars.length){
            int count = 1;
            while(j+1 < chars.length && chars[j+1] == chars[j]){
                count ++;
                j++;
            }
            //save result
            chars[i] = chars[j];
            // count could be 2 or more digits
            String cs = Integer.toString(count);
            for(char c : cs.toCharArray()){
                chars[i+1] = c;
                i++;
            }
            i++;
            j++;// go to next letter
        }
        return i;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        new StringCompression().compress(chars);
    }

}
