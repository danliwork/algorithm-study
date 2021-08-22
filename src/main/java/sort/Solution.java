package sort;

import java.util.Arrays;

public class Solution {

    public void bubbleSort(int[] nums){
        //edge cases
        if(nums == null || nums.length == 0){
            return;
        }

        //main
        //for i -> [length-1, 0)
        //for j = [0, i)  if j+1 < j, swap
        for(int i=nums.length -1; i>0; i--){
            for(int j = 0; j<i; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }

    }


    public void insertionSort(int[] nums){
        //edge cases
        if(nums == null || nums.length == 0){
            return;
        }

        //main
        for(int i = 1; i<nums.length; i++){
            int newEle = nums[i];
            int j;
            for(j = i; j > 0 && nums[j-1] > newEle; j--){
                nums[j] = nums[j-1];
            }
            nums[j] = newEle;
        }

    }


    public void selectionSort(int[] nums){
        //edge cases
        if(nums == null || nums.length==0){
            return;
        }
        // main
        for(int i = nums.length -1; i > 0; i--){
            int maxIndex = i;
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[maxIndex]){
                    maxIndex = j;
                }
            }
            swap(nums, i, maxIndex);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String [] args){
        int[] nums = {20, 35, -15, 7, 55, 1, -22};
        new Solution().insertionSort(nums);
        System.out.println(Arrays.toString(nums).equals("[-22, -15, 1, 7, 20, 35, 55]"));
    }

}
