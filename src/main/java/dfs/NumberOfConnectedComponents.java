package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumberOfConnectedComponents {
    //given number of vertxs, edges
    public int countComponent(int n, int[][] edges){
        //edge cases
        if(n<=0 || edges==null || edges.length ==0 || edges[0].length ==0) return 0;

        //build a graph:
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i< n; i++){
            if(!visited[i]){
                count++;
                dfs(i, graph, visited);
            }
        }
        return count;
    }


    private void dfs(int i, List<List<Integer>> adjList, boolean[] visited){
        Deque<Integer> stack = new ArrayDeque<>();

        stack.add(i);
        visited[i] = true;

        while(!stack.isEmpty()){
            int curr = stack.pop();
            List<Integer> children = adjList.get(curr);
            if(children != null) { //forget to check
                for (int c : children) {
                    if (!visited[c]) {
                        visited[c] = true;
                        stack.push(c);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2},  {3,4}};
        int n = 5;
        int result = new NumberOfConnectedComponents().countComponent(n, edges);
        System.out.println("Number of disconnected comp is: " + result);
    }
}
