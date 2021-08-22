package array;

import java.util.stream.IntStream;

public class ProductOfArrayExceptItself {

    public static int[] productOfArrayExceptItself(int[] nums){
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        IntStream.range(1,length).forEach( i-> {
            result[i] = result[i-1] * nums[i-1];

        });

        int base = 1;
        for(int i=length-2; i>=0; i--){
            base *= nums[i+1];
            result [i] = result[i] * base;
        }
        return result;
    }
}
