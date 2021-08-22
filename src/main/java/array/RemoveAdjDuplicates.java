package array;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjDuplicates {
    public String removeDuplicates(String s) {
        Deque<Character> stack  = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(stack.peek() == c){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        //covert the stack back to string?
        //return new String(stack.stream().toArray());
        //return stack.stream().map(c -> "" +  c).collect(Collectors.joining(""));
        Character[] a = stack.toArray(new Character[stack.size()]);
        Character[] b = stack.stream().toArray(Character[]::new);//Character[]::new is a intarrayGenerator take the 'size' and return the array
       // char[] c = stack.stream().map(cr -> cr.charValue()).toArray();
        return "";
    }


}
