package graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
class AlterColorPath {
    // if all weights are same , shorest path using BFS
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, List<int[]>> graph = build(red_edges, blue_edges);
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> ans[a[0]] - ans[b[0]]);
        // value, color, path length
        q.add(new int[]{0,0,0});
        ans[0] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int v = cur[0];
            int color = cur[1];
            int pathLength = cur[2];
            visited[v] = true;

            for(int[] nb : graph.getOrDefault(v, Collections.emptyList())){
                int nv = nb[0];
                int nColor = nb[1];
                if((v != 0 && color == nColor) ){
                    continue;
                }
                int newDist = pathLength + 1;
                if(newDist < ans[nv]){
                    ans[nv] = newDist;
                }
                q.add(new int[]{nv,nColor,newDist});
            }


        }
        for(int i = 0; i<n; i++){
            if (ans[i] == Integer.MAX_VALUE){
                ans[i] = -1;
            }
        }
        return ans;
    }

    //0 red, 1 blue
    private Map<Integer, List<int[]>> build(int[][] red_edges, int[][] blue_edges){
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] re : red_edges){
            map.computeIfAbsent(re[0], key -> new ArrayList<>()).add(new int[]{re[1], 0});
        }
        for(int[] be : blue_edges){
            map.computeIfAbsent(be[0], key -> new ArrayList<>()).add(new int[]{be[1], 1});
        }
        return map;
    }


    public static void main(String[] args) {
        int[][] red_edges ={{0,1},{1,2},{2,3},{3,4}};
        int[][] blue_edges ={{1,2},{2,3},{3,1}};
        int[] res = new AlterColorPath().shortestAlternatingPaths(5, red_edges, blue_edges);
        log.info("res={}", res);

    }


}
