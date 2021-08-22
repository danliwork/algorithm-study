package dfs;


import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
class NQueens {
    int res;
    private final Set<Integer> occupiedRows = new HashSet<Integer>();
    private final Set<Integer> occupiedCols = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();

    public int totalNQueens(int n) {
         dfs(n, 0);
         return res;
    }

    private void dfs(int n, int r){
        if(r == n){
            res++;
            return;
        }
       // int res = 0;
            for(int c = 0; c <n; c++){
                int diff= r-c;
                int sum = r+c;

                if(!occupiedRows.contains(r) && !occupiedCols.contains(c)
                        && !occupiedDiag1s.contains(diff) && !occupiedDiag2s.contains(sum)){

                    // add the queen
                    occupiedCols.add(c);
                    occupiedDiag1s.add(diff);
                    occupiedDiag2s.add(sum);
                    log.info("remain= {}, put {} {}", r, c);

                    dfs(n, r+1);
                    // remove the queen
                    occupiedCols.remove(c);
                    occupiedDiag1s.remove(diff);
                    occupiedDiag2s.remove(sum);
                    log.info("remain= {}, removed {} {}", r, c);
                }
            }
    }

    public static void main(String[] args) {
        log.info("ans= {}" + new NQueens().totalNQueens(4));
    }
}
