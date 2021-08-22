package binarysearch;

public class FindMissingNumberInSortedArray {

    public static int findMissingNumerInSortedArray(int[] nums){
        //edge case
        if(nums == null || nums.length == 0) return -1;

        //binary search
        //g(i) = nums[i] - i = 2;
        int l = 0, r = nums.length;
        while(l < r){
            int m = l + (r-l)/2;
            if(nums[m] - m == 2){
                r = m;
            } else {
                l = m+1;
            }
        }
        return nums[l] - 1;
    }


    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,6,7,8,9};
        int[] arr2 = {1,2,3,4,5,6,8};
        System.out.println(findMissingNumerInSortedArray(arr1)) ;
        System.out.println(findMissingNumerInSortedArray(arr2)) ;
    }
}
