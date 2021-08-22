package graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = build(equations, values);
        double[] res = new double[queries.size()];
        for(int i = 0; i<queries.size(); i++){
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, 1, new HashSet<>());
        }
        return res;
    }

    private double dfs(String start, String target, Map<String, Map<String, Double>> graph, double pathValueIncludeCur, Set<String> used){
        if(start.equals(target)){
            return pathValueIncludeCur;
        }

        used.add(start);
        double res = -1.0;
        for(Map.Entry<String, Double> nb : graph.getOrDefault(start, Collections.emptyMap()).entrySet()){
            String c = nb.getKey();
            double w = nb.getValue();
            if(used.contains(c)) continue;
            double cRes = dfs(c, target, graph, pathValueIncludeCur*w, used);
            if(cRes > 0){
                return cRes;
            }
        }
        used.remove(start);
        return res;
    }

    private Map<String, Map<String, Double>> build(List<List<String>> equations, double[] values){
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i<equations.size(); i++){
            List<String> e = equations.get(i);
            double w = values[i];
            map.computeIfAbsent(e.get(0), key -> new HashMap<>()).put(e.get(1), w);
            map.computeIfAbsent(e.get(1), key -> new HashMap<>()).put(e.get(0), 1/w);
        }
        return map;
    }

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(Arrays.asList("x1", "x2"),
                Arrays.asList("x2", "x3"),
                Arrays.asList("x3", "x4"),
                Arrays.asList("x5", "x6"));
        double[] values = {3.0,4.0,5.0,6.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("x2", "x4"));

        List<List<String>> equations2 = Arrays.asList(Arrays.asList("a", "b"),
                Arrays.asList("b", "c"));
        double[] values2 = {2.0,3.0};
        List<List<String>> queries2 = Arrays.asList(Arrays.asList("x", "x"));


        double[] res = new EvaluateDivision().calcEquation(equations2,values2,queries2);
        log.info("" + Arrays.toString(res));
    }
}
