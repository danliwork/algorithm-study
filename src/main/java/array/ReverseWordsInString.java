package array;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        //corner case
        if(s == null || s.length() == 0){
            return s;
        }

        //main
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length-1; i>=0; i--){
            String ps = strs[i].trim();
            if(!ps.equals("")){
                sb.append(ps);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good       example";
        String res = new ReverseWordsInString().reverseWords(s);
        System.out.println(res);
    }
}
