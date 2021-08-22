package array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 *
 */
public class TwoSums {

    //my solution
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if(length < 2) return new int[0];
        Map<Integer, Integer> diffAndIndex = new HashMap();
        int[] result = new int[2];
        IntStream.range(0, nums.length).forEach( i -> {
            int element = nums[i];
            if(diffAndIndex.containsKey(element)){
                result[0] = diffAndIndex.get(element);
                result[1] = i;
            } else {
                diffAndIndex.put(target-element, i);
            }
        });
        return result;
    }

    //better format
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; numMap.put(nums[i], i++)){
            if(numMap.containsKey(target - nums[i]))
                return new int[]{numMap.get(target-nums[i]), i};
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,5,3,7,8,4,6};
        //Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));
        twoSum(arr, 5);
    }
}
