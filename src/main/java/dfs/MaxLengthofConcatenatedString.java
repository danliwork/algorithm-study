package dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxLengthofConcatenatedString {
    private int res;
    public int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0){
            return 0;
        }
        //dfs
        dfs(arr, 0, new String());
        return res;
    }

    private void dfs(List<String> arr, int start, String path){
        if(start >= arr.size()){
            return;
        }
        for(int i = start; i< arr.size(); i++){
            String newS = path+arr.get(i);
            if(isUnique(newS)){
                res = Math.max(res, newS.length());
                dfs(arr, i+1, newS);
            }
        }
    }

    private boolean isUnique(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                return false;
            } else {
                map.put(c, 1);
            }
        }
        return true;
    }

    public static void swap(Integer a, Integer b){
        a = new Integer(10);
        b = new Integer(15);
    }

    public static void main(String[] args) {
        int x = new MaxLengthofConcatenatedString().maxLength(Arrays.asList("un","iq","ue"));
        System.out.println("res=" + x );


        Integer a = new Integer(2);
        Integer b = new Integer(3);

        swap(a, b);
        System.out.println("a=" + a ); //out put =2
        System.out.println("b=" + b );  //output =3



    }
}
