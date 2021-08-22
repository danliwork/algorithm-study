package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountSubTreesWithMaxDistanceBetweenCities {
    public static  int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        if( n <= 1 || edges == null || edges.length == 0 || edges[0].length == 0){
            return new int[0];
        }

        int[] res = new int[n-1];
        Map<Integer, List<Integer>> map = getAdjList(edges);

        for(int d = 1; d < n ; d++){
            for(int c = 1; c <=n; c++){
                res[d-1] += dfs(d, c, 1, map, new boolean[n + 1]);
            }
        }

        return res;
    }


    // count number of paths that distance = d
    public static  int dfs(int d, int city, int dis, Map<Integer, List<Integer>> edges, boolean[] visited){


        if(dis == d + 1){
            return 1;
        }

        if(visited[city]){
            return 0;
        }

        visited[city] = true;
        int total = 0;
        for(int nei : edges.get(city)){
            total += dfs(d, nei, dis+1, edges, visited);
        }
        visited[city] = false;
        return total;

    }

    //convert to adjucency list, east to fetch neibours(children) for each city
    public static Map<Integer, List<Integer>> getAdjList(int[][] edges){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] e : edges){
            if(!map.containsKey(e[0])){
                map.put(e[0], new ArrayList<>());
            }
            if(!map.containsKey(e[1])){
                map.put(e[1], new ArrayList<>());
            }
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        return map;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1,2},
                {2,3},
                {2,4},
        };

        countSubgraphsForEachDiameter (4, edges);
    }
}