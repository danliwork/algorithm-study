package graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
class RestrictedPaths {
    private int M=(int)1e9+7;

    public int countRestrictedPaths(int n, int[][] edges) {
        //build the weighted undirected graph
        Map<Integer, List<int[]>> graph = build(edges);
        // from n to all other nodes, using DJ to find the shortest path, cache it
        int[] dist = new int[n+1];
        djshortestPath(graph, dist, n, new boolean[n+1] );
        // from 1 find all path to n, for each one check shorestDistance
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dfs(1, n, graph, dist, new boolean[n+1], memo );
    }

    private int dfs(int start, int target, Map<Integer, List<int[]>> graph, int[] dist, boolean[] visited, int[] memo){
        if(start == target){
            return 1;
        }
        if(memo[start] !=-1){
            return memo[start];
        }
        int ans = 0;
        //visited[start] = true;
        for(int[] nb : graph.getOrDefault(start, Collections.emptyList())){
            int nbV = nb[0];
            if(dist[start] <= dist[nbV]){
                continue;
            }
            ans = (ans + dfs(nbV, target, graph, dist, visited, memo))%M;
        }
        //visited[start] = false;
        memo[start] = ans;
        return ans;
    }


    private void djshortestPath(Map<Integer, List<int[]>> graph, int[] dist, int n, boolean[] visited){
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> dist[a[0]] - dist[b[0]]);// why this iw wrong?
        //PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        //PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(dist[a[0]],dist[b[0]]));
        pq.add(new int[]{n, 0});
        dist[n] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int v = cur[0];
            int d = cur[1];// here the second value is dist
            visited[v] = true;
            for(int[] nb : graph.getOrDefault(v, Collections.emptyList())){
                int nbV = nb[0];
                int nbW = nb[1];
                if(visited[nbV]) continue;
                int newDist = d + nbW;// old dist not old weight
                if(newDist < dist[nbV]){
                    dist[nbV] = newDist;
                    // !!! forget important again!!!
                    pq.offer(new int[]{nbV, newDist});
                }
            }
        }
    }

    private Map<Integer, List<int[]>> build(int[][] edges){
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] e : edges){
            int v1 = e[0];
            int v2 = e[1];
            int w = e[2];
            map.computeIfAbsent(v1, key -> new ArrayList()).add(new int[]{v2, w});
            map.computeIfAbsent(v2, key -> new ArrayList()).add(new int[]{v1, w});
        }
        return map;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,3,1},{4,1,2},{7,3,4},{2,5,3},{5,6,1},{6,7,2},{7,5,3},{2,6,4}};
        int res = new RestrictedPaths().countRestrictedPaths(7, edges);
        log.info("res={}", res);
    }
}
