package array;

public class SearchInRotatedarray {
    public static boolean search(int[] nums, int target) {
        if(nums==null || nums.length ==0)
            return false;

        int l = 0;
        int r = nums.length;
        while(l<r){
            int m = l + (r-l)/2;
            if(nums[m] == target) return true;

            while(nums[m] == nums[l] && nums[m]==nums[r-1]&& l !=r-1){
                l++;
            }
            // In our case, we need to think of the pivot
            boolean leftSorted = nums[l] < nums[m] || l == m;
            boolean rightSorted = nums[m] < nums[r-1] || r-1 == m;
            // We go left one two conditions:
            // leftSide is sorted and the number is between there
            // the right side is sorted but the number is not between there
            if ((leftSorted && nums[l] <= target && nums[m] > target)
                    || (rightSorted && !(nums[m] < target && nums[r-1] >= target))) {
                r = m; //[l, m)
            } else {
                l = m + 1;//[m+1, r)
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 3,1};
        //Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));
        search(arr, 3);
    }
}
