package graph;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class maxDistance {
    //similar as 1756 https://leetcode.com/problems/map-of-highest-peak/
    //BFS on grid with multiple starts
    private static int[] DIREC = {0,1,0,-1,0};
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[grid.length][grid[0].length];

        for(int i = 0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    dist[i][j] = 0;
                    q.add(new int[]{i,j});
                } else {
                    dist[i][j] = -1; // not visited
                }
            }
        }

        //bfs
        int maxDist = bfs(q, dist);
        return maxDist;
    }


    private int bfs(Queue<int[]> q, int[][] dist){
        int maxDist = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            int d = dist[r][c];
            maxDist = Math.max(maxDist, d);
            for(int k = 0; k<4; k++){
                int nr = r + DIREC[k];
                int nc = c + DIREC[k+1];
                //r = r + DIREC[k];
                //c = c + DIREC[k+1];//CAUSION!! can not write like this, it cumulated in 4  loop
                // check edge condition
                if(nr <0 || nr>=dist.length || nc <0 || nc >=dist[0].length || dist[nr][nc] != -1){
                    continue;
                }
                dist[nr][nc] = d+1;
                q.add(new int[]{nr,nc});
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        int res = new maxDistance().maxDistance(grid);
        log.info("res=" + res);

    }
}
