package dfs;

import java.util.*;

public class MinimizePermutations {

    // Add any helper functions you may need here
    String getString(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i);
        }
        return sb.toString();
    }

    String reverse(String init, int s, int e){
        int i = s, j = e;
        char[] arr = init.toCharArray();
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    int BFS(String init, String dest){
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();

        queue.add(init);
        visited.add(init);

        int level = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            //for all node on save level
            for(int m=0; m<n; m++){
                String node = queue.poll();
                if(node.equals(dest)){
                    return level;
                }

                //add children
                for(int i=0; i<init.length()-1; i++){
                    for(int j=i+1; j<init.length(); j++){
                        String c = reverse(init, i, j);
                        if(!visited.contains(c)){
                            queue.add(c);
                            visited.add(c);
                        }
                    }
                }
            }
            level ++;
        }
        return level;

    }

    int minOperations(int[] arr) {
        // Write your code here
        //corner cases
        if(arr == null || arr.length == 0) return 0;

        String init = getString(arr);
        Arrays.sort(arr);
        String dest = getString(arr);
        return BFS(init,dest);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2};
        int res = new MinimizePermutations().minOperations(arr);
        System.out.println("Answer is: " + res);

        int[] arr1 = new int[]{3,4,5};
        int[] arr2 = new int[]{6,7,8};



        int b = 0;





    }

}
