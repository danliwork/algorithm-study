package array;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

        public static List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();

            if(nums.length < 3) return Collections.EMPTY_LIST;

            for(int i=0; i<nums.length-2; i++){
                int ele = nums[i];
                List<int[]> otherTwo = twoSum(nums, i+1, -ele);
                if(!otherTwo.isEmpty()){
                    //otherTwo.forEach(o -> result.add(new HashSet<Integer>(Arrays.asList(ele, o[0], o[1]))));
                }
            }
            return result.stream().map(s -> new ArrayList<Integer>(s)).collect(Collectors.toList());
        }

        private static List<int[]> twoSum(int[] nums, int start, int target){
            List<int[]> result = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int i=start; i<nums.length; i++){
                if(set.contains(target-nums[i])){
                    result.add (new int[]{nums[i], target-nums[i]});
                } else {
                    set.add(nums[i]);
                }
            }
            return result;
        }

        private class Tripler{
            int a;
            int b;
            int c;

            @Override
            public int hashCode() {
                int result = a;
                result = result*31 + b;
                result = result*31 + c;
                return result;
            }


        }

    public static void main(String[] args) {
        int[] arr = { -1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(arr);
        result.forEach( list -> list.toString());
    }
}
