package dfs;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CountUniqueNumbers {

    public static int dfs(int n, int length, List<Integer> path){
        if(length == n){
            return 1;
        }

        int sum = 0;//why =1 not 0?
        for(int i = 0; i<=2; i++){
            //if(path.stream().allMatch(e -> e==0) && i==0) continue; // why add here can skip a lot more?
            if(path.contains(i)) continue;
            path.add(i);
            sum += dfs(n, length+1, path);
            path.remove(path.size()-1);
        }
        return sum;
    }

    public static void main(String[] args) {

       // int res =  dfs(3, 0, new ArrayList<>()) +1 ;
       // System.out.println("res=" + res);
        List<Integer> path = new ArrayList<>();
        log.info( "res=" + path.stream().allMatch(e -> e==0));

    }
}
