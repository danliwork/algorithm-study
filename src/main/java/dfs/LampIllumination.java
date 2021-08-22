package dfs;

import java.util.HashSet;
import java.util.Set;



class LampIllumination {
    private static int[][] directions = {{0,0}, {0,1},{0,-1},{1,0},{-1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
    private Set<String> lampsKey = new HashSet<>();
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] ir = new int[N];
        int[] ic = new int[N];
        int[] id1 = new int[N * 2];
        int[] id2 = new int[N * 2];

        for(int[] l : lamps){
            int r = l[0];
            int c = l[1];
            int d1 = r-c + N;
            int d2 = r+c;
            ir[r] ++;
            ic[c] ++;
            id1[d1] ++;
            id2[d2] ++;
            lampsKey.add("" + r+c+d1+d2);
        }

        int[] res = new int[queries.length];
        for(int i = 0;i<queries.length; i++){
            int[] cur = queries[i];
            int r = cur[0];
            int c = cur[1];
            int d1 = r-c + N;
            int d2 = r+c;
            if(ir[r] > 0 || ic[c] > 0 || id1[d1]  > 0|| id1[d2] > 0) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
            //turnoff lamps, update maps
            for(int[] d : directions){
                int rd = cur[0] + d[0];
                int cd = cur[1] + d[1];
                if(rd < 0 || rd >=N ||cd<0 || cd>=N) continue;
                int d1d = r-c + N;
                int d2d = r+c;
                if(!lampsKey.contains(""+rd+cd+d1d+d2d)) continue;
                if(ir[rd] > 0 )ir[rd] --;
                if(ic[cd] > 0 )ic[cd] --;
                if(id1[d1d] > 0 )id1[d1d] --;
                if(id2[d2d] > 0 )id2[d2d] --;
                lampsKey.remove(""+rd+cd+d1d+d2d);
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[][] lamps = {{0,0},{4,4}};
        int[][] q = {{1,1},{1,0}};
        new LampIllumination().gridIllumination(5, lamps,q);

    }
}
