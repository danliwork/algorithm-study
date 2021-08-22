package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeingString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int i = 0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                int count = 0;
                while(Character.isDigit(s.charAt(i))){
                    count = count*10 + s.charAt(i)-'0';
                    i++;
                }
                countStack.push(count);
            }
            if(s.charAt(i) == '['){
                strStack.push(Character.toString(s.charAt(i)));
                i++;
            }
            if(Character.isLetter(s.charAt(i))){
                StringBuilder sb = new StringBuilder();
                while(Character.isLetter(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
                strStack.push(sb.toString());
            }

            if(s.charAt(i) == ']'){
                int cnt = countStack.pop();
                StringBuilder sb = new StringBuilder();
                String c = strStack.pop();
                while(!c.equals("[")){
                    sb.insert(0,c);
                    c = strStack.pop();
                }
                String str = sb.toString();
                for(int j = 0; j<cnt-1; j++){
                    sb.append(str);
                }
                strStack.push(sb.toString());
                i++;
            }
        }

        StringBuilder res = new StringBuilder();
        while(!strStack.isEmpty()){
            res.insert(0, strStack.pop());
        }
        return res.toString();
    }



    public static void main(String[] args) {
        String res = new DecodeingString().decodeString("2[abc]3[cd]ef");
        System.out.println("3[a]2[bc]=" +  new DecodeingString().decodeString("3[a]2[bc]"));
        System.out.println("3[a2[c]]=" +  new DecodeingString().decodeString("3[a2[c]]"));

    }
}
