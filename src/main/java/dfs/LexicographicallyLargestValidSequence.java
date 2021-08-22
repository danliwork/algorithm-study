package dfs;


import java.util.ArrayList;
import java.util.List;

class LexicographicallyLargestValidSequence {
    public static int[] constructDistancedSequence(int n) {
        if(n<2){
            return new int[0];
        }
        // nums is sorted DESC so we found the largest one first
        int[] nums = getNumsFromN(n);
        List<int[]> res = new ArrayList<>();
        dfs(nums, res, new int[nums.length], new boolean[nums.length], 0);
        return res.get(0);
    }


    private static void dfs(int[] nums, List<int[]> res, int[] path, boolean[] used, int index){
        //I do not know how to full stop after found the first one
        if(index == nums.length){
            int[] ans = new int[path.length];
            System.arraycopy(path, 0 ,ans, 0, path.length);
            res.add(ans);
            return;
        }
        // full stop when we found first answer
        if(!res.isEmpty()) return;

        //!!! 常犯错误： using i instead of nums[i] !!!!
        for(int i = 0; i<nums.length; i++){
            if(used[i] ) continue;//used
            if(nums[i] != 1){

                if(i > 0){
                    if(nums[i] == nums[i-1] && !used [i-1]) continue;
                }
                if ((index > 0 && nums[i] == path[index-1]) //same as last
                        || (index - nums[i] > 0 && path[index - nums[i]] != nums[i]) //distance not match
                    ) continue;
            }


            path[index] = nums[i];
            used[i] = true;
            dfs(nums, res, path, used, index+1);
            path[index] = 0;
            used[i] = false;
        }
    }

    private boolean matchDistance(List<Integer> path, int num){
        int pos = -1;
        for(int i = 0; i< path.size(); i++){
            if(path.get(i) == num){
                pos = i;
                break;
            }
        }
        return pos == -1 || path.size() - pos == num;
    }

    private static int[] getNumsFromN(int n){
        int[] nums = new int[1+(n-1)*2];

        for(int i = 0; i< nums.length-1 && n>1; i+=2){
            nums[i] = n;
            nums[i+1] = n;
            n--;
        }
        nums[nums.length-1] = 1;
        return nums;
    }


    public static void main(String[] args) {
        //int[] nums = getNumsFromN(3);
        //boolean match = matchDistance(Arrays.asList(3,1,2), 3);
        constructDistancedSequence(3);
    }


}
