package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        //edge cases
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        //main
        dfs(nums, result, new ArrayList<>(), new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, List<Integer> used){
        //stop con
        if(path.size()==nums.length){
            System.out.println("set: " +new ArrayList<>(path));
            result.add(new ArrayList<>(path));
        }

        //branching
        for(int i=0; i<nums.length; i++){
            //if(i>0 && nums[i] == nums[i-1]) continue;
            if(used.contains(i) || (i>0 && nums[i] == nums[i-1] && used.contains(i-1))){
                continue;
            }
            used.add(i);
            path.add(nums[i]);
            dfs(nums, result, path, used);
            used.remove(used.size()-1);
            path.remove(path.size()-1);

        }
    }

    public static void main(String[] args){
        int[] input = {1,2,3};
        new PermutationUnique().permuteUnique(input);
    }
}
