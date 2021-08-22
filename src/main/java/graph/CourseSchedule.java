package graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        // use each course as start, check if there is a cycle
        for(int i = 0; i<numCourses; i++){
            if(!dfs(i, graph, new boolean[numCourses])){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int start, Map<Integer, List<Integer>> graph, boolean[] used){
        used[start] = true;

        for(int nb : graph.getOrDefault(start, Collections.emptyList())){
            if(used[nb]){
                return false;
            }
            dfs(nb, graph, used);
        }
        used[start] = false;
        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p: prerequisites){
            map.computeIfAbsent(p[1], k-> new ArrayList<>()).add(p[0]);
        }
        return map;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        new CourseSchedule().canFinish(2, grid);
    }
}
