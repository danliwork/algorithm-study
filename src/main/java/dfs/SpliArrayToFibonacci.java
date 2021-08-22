package dfs;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SpliArrayToFibonacci {
    public static List<Integer> splitIntoFibonacci(String S) {
        if(S == null || S.length() ==0){
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        //dfs
        dfs(S, res, new ArrayList<>(), 0);
        return res;
    }

    private static void dfs(String s, List<Integer> res, List<Integer> path, int start){
        if(start >= s.length()){
            res.addAll(path);
            return;
        }

        if(!res.isEmpty()){
            return;
        }

        for(int len = 1; len <= s.length() - start; len ++){
            int sub = Integer.parseInt(s.substring(start, start+len));
            if(path.size() < 2 || (sub == path.get(path.size()-1) + path.get(path.size()-2))){
                path.add(sub);
                dfs(s, res, path, start + len);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        splitIntoFibonacci("123456579");
    }
}
