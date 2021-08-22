package sort;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int[] copy1 = new int[m];
         int[] copy2 = new int[n];
         copy(nums1, copy1, m);
         copy(nums2, copy2, n);
         int i = 0, j=0, k=0;
         while(i < m && j < n && k < m + n){
             int a = copy1[i];
             int b = copy1[j];
             if(a <= b){
                 nums1[k] = a;
                 i++;
             } else {
                 nums1[k] = b;
                 j++;
             }
             k++;
         }


    }

    private void copy(int[] arr1, int[]arr2, int length){
        for(int i=0; i<length; i++){
            arr2[i] = arr1[i];
        }
    }

    public static void main(String [] args){
        String s = "loveleetcode";

        System.out.println("");
    }
}
