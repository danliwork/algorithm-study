package dfs;


import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    int nums = 0;

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        backTrack(n, ret);
        return ret;
    }

    private void backTrack(int n, List<Integer> ret) {
        if (n == 0) {
            ret.add(nums);
            System.out.println("add nums=" + nums);
            return;
        }
        else {
            backTrack(n - 1, ret);
            nums ^= (1 << n - 1);
            System.out.println("n=" + n + "nums=" + nums);
            backTrack(n - 1, ret);
        }
    }

    public static int binaryToInt(char[] nums){
        int res = 0;
        for(int i= 0; i<nums.length; i++){
            int square = nums.length-1-i;
            int digit = nums[i] - '0';
            res+=((2^square) * digit);
        }
        return res;
    }

    private static class Person{
        @NotNull
        String name;

        public Person(String name){
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Person p  = new Person(null);

    }


}
