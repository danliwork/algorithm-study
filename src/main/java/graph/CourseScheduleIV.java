package graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;


@Slf4j
class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> graph = buildGraph(queries);
        Map<Integer, Boolean> memo = new HashMap<>();
        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries){
            res.add(dfs(graph, q[0], q[1], new boolean[numCourses], memo));
        }
        return res;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int target, boolean[] used, Map<Integer, Boolean> memo){
        if(source == target){
            return true;
        }
        if(memo.containsKey(source)){
            return memo.get(source);
        }


        used[source] = true;
        boolean canDo = false;
        for(int nb : graph.getOrDefault(source, Collections.emptyList())){
            if(dfs(graph, nb, target, used, memo)){
                canDo = true;
            }
        }
        used[source] = false;
        memo.put(source, canDo);
        return canDo;
    }


    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] e : prerequisites){
            int v1 = e[0];
            int v2 = e[1];
            map.computeIfAbsent(v1, k-> new ArrayList<>()).add(v2);
        }
        return map;
    }

    public static void main(String[] args) {
        int[][] queries = {{0,1},{1,0}};
        int[][] prerequisites = {{1,0}};
        List<Boolean> res = new CourseScheduleIV().checkIfPrerequisite(5, prerequisites, queries);
        log.info("RES= " + res);
    }
}