package graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MaxProbs {
    double res;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[][] weights = new double[n][n];
        Map<Integer, List<Integer>> graph = build(edges, weights, succProb);
        dfs(graph, weights, start, end, 0, new boolean[n]);
        return res;
    }

    private void dfs(Map<Integer, List<Integer>> graph, double[][] weights, int i, int target, double prob, boolean[] onpath){
        if(i == target){
            res = Math.max(prob, res);
        }

        onpath[i] = true;
        if(graph.containsKey(i)){
            for(int c : graph.get(i)){
                if(onpath[c]) continue;
                onpath[c] = true;
                double cp = weights[i][c];
                dfs(graph, weights, c, target, prob == 0 ? cp : prob*cp, onpath);
                onpath[c] = false;
            }
        }
    }

    private Map<Integer, List<Integer>> build(int[][] edges, double[][] weights, double[] succProb){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<edges.length; i++){
            int[] e = edges[i];
            weights[e[0]][e[1]] = succProb[i];
            weights[e[1]][e[0]] = succProb[i];
            map.computeIfAbsent(e[0], key -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], key -> new ArrayList<>()).add(e[0]);
        }
        return map;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5, 0.5, 0.3};
        double ans = new MaxProbs().maxProbability(3, edges, succProb, 0, 2);
        log.info("ans=" + ans);

    }
}
