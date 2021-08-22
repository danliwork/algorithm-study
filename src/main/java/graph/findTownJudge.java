package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class findTownJudge {
    public int findJudge(int n, int[][] trust) {
        // build a adjList Map<Integer, Set<Integer>>
        // find the i that not in map,a dn exists in all sets

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] t : trust){
            map.computeIfAbsent(t[0], key -> new HashSet<>()).add(t[1]);
        }
        for(int i = 1; i<=n; i++){
            int p = i;
            if(!map.containsKey(i) && map.values().stream().allMatch(set -> set.contains(p))){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new findTownJudge().findJudge(2, new int[0][0]);
    }
}
