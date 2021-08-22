package array;

import java.util.*;

public class FindMaximumDepthOfNestedString {

    private List<String> maximumDepthString(String s){
        //edge cases
        if(s == null || s.length() == 0) return Collections.emptyList();
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        char last = ' ';
        List<String> res = new ArrayList<>();
        while(i < s.length()){
            char c = s.charAt(i);
            //1.if is left half,
            // 1.add to stack,
            // 2.set last  = ' ', we will have a new depth, i++
            if(c == '('){
                stack.addFirst(c);
                last = ' ';
                i++;
            }
            //2. if  is letter, add to stack, i++
            if(Character.isLetter(c)){
                stack.addFirst(c);
                i++;
            }
            //3. if is right half:
            // 1.pop all the char until '(' OR 'empty' --> str
            // 2.pop '(' if exist, i++
            //
            if(c == ')'){
                //get all the chars to a string until '('
                String topString = getTopString(stack);
                if(last == ' '){
                   last = ')';
                   res.add(topString);
               }
               if(!stack.isEmpty() && stack.getFirst() == '('){
                   stack.removeFirst(); // pop '（'
               }
               i++;
            }
        }
        return res;
    }

    private String getTopString(Deque<Character> stack){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && Character.isLetter(stack.getFirst())){
            char top = stack.removeFirst();
            sb.insert(0, top);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        List<String> res = new FindMaximumDepthOfNestedString().maximumDepthString("ran(n(d))o(m())");
        System.out.println(res.toArray());
    }
}
