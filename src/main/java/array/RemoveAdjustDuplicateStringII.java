package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjustDuplicateStringII {
    public String removeDuplicates(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return s;
        Deque<CharAndFreq> stack = new ArrayDeque<>();
        int i = 0;
        while(i < s.length()){
            if(stack.isEmpty() || s.charAt(i) != stack.getFirst().letter){
                stack.push(new CharAndFreq(s.charAt(i)));
            } else {
                int count = stack.getFirst().increment();
                if(count == k) stack.pop();
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(CharAndFreq cf : stack){
            sb.insert(0, cf.toString());
        }
        return sb.toString();
    }

    private class CharAndFreq{
        public final char letter;
        public int count;

        public CharAndFreq(char c){
            this.letter = c;
            count = 1;
        }

        public int increment(){
            return ++count;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<count; i++){
                sb.append(letter);
            }
            return sb.toString();

        }
    }

    public static void main(String[] args) {
        //System.out.println("deeedbbcccbdaa=" +  new RemoveAdjustDuplicateStringII().removeDuplicates("deeedbbcccbdaa", 3));
    }
}
