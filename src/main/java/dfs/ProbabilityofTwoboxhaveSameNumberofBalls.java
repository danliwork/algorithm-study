package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ProbabilityofTwoboxhaveSameNumberofBalls {
    private static int total = 0;
    private static int same = 0;

    public static double getProbability(int[] balls) {
        if(balls == null || balls.length == 0) return 0;
        int n = 0;
        for(int count : balls){
            n += count;
        }
        dfs(balls, new HashSet<>(), new HashSet<>(), 0, n/2);
        return (double)same/total;
    }

    private static void dfs(int[] balls, Set<Integer> box1, Set<Integer> box2, int pathLength, int n){
        // reached end
        if(pathLength == 2*n){
            total ++;
            if(box1.size() == box2.size()){
                same ++;
            }
            return;
        }
        for(int k=1; k<=balls.length; k++){
            if(balls[k-1] > 0){ // still have balls with color k
                if(pathLength < n){
                    box1.add(k);
                } else {
                    box2.add(k);
                }
                balls[k-1] --;
                dfs(balls, box1, box2, pathLength +1, n);
                if(pathLength < n){
                    box1.remove(k);
                } else {
                    box2.remove(k);
                }
                balls[k-1] ++;
            }
        }
    }

    public static void main(String[] args) {
        //int[] balls = {2,1,1};
       // getProbability(balls);

        List<Integer> path = new ArrayList<>();
    }
}
