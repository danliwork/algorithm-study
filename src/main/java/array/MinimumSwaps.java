package array;

import java.util.Arrays;

public class MinimumSwaps {
    //https://www.includehelp.com/java-programs/minimum-swaps-required-to-sort-an-array.aspx

    private static int minimumSwapsCycle(int[] arr) {
        int swap=0;
        boolean visited[]=new boolean[arr.length];

        for(int i=0;i<arr.length;i++){
            int cycle = countCycleForI(i, visited, arr);

            if(cycle!=0)
                swap+=cycle-1;
        }
        return swap;
    }

    private static int countCycleForI(int i, boolean[] visited, int[] arr){
        int j=i,cycle=0;

        while(!visited[j]){
            visited[j]=true;
            j=arr[j]-1;// next sorted position
            cycle++;
        }
        return cycle;
    }

    public static int minimumSwapsWrong(int[] arr) {
        int count = 0;
        int length = arr.length;
        if(length < 2) return count;
        int lastUnsortedIndex = length -1;
        for(int i=lastUnsortedIndex; i>0; i-- ){
            int max = Integer.MIN_VALUE;
            int max_Index = -1;

            for (int j = 0; j<=i;j++){
                if(arr[j] > max) {
                    max = arr[j];
                    max_Index = j;
                }
            }
             if(max_Index >= 0 && max_Index != i) {
                 swap(arr, max_Index, i);
                 count++;
             }
        }
        return count;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = { 2,3,4,1,5};
        Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));
        System.out.println();
        System.out.println(minimumSwapsCycle(arr));
    }

}
