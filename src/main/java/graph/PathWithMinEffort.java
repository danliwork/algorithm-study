package graph;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PathWithMinEffort {
    //idea 2 : dfs
    int res = 0;
    public  int minimumEffortPath(int[][] heights) {
        dfs(0,0,heights,0,heights[0][0]);
        return res;
    }

    private void dfs(int r, int c, int[][] heights, int maxDiff, int prevHeight){

        //stop
        if(r < 0 || r>=heights.length || c < 0 || c >= heights[0].length){
            return;
        }

        int curheight = heights[r][c];
        maxDiff = Math.max(maxDiff, Math.abs(prevHeight - curheight));
        // top right corner
        if(r == heights.length-1 && c == heights[0].length-1){
            res = Math.min(res, maxDiff);
        }

        dfs(r-1,c,heights, maxDiff, curheight);
        dfs(r,c-1,heights, maxDiff, curheight);
        dfs(r+1,c,heights, maxDiff, curheight);
        dfs(r,c+1,heights, maxDiff, curheight);

    }




    public static void main(String[] args) {
        int[][] heights = {{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}};
        int res = new PathWithMinEffort(). minimumEffortPath(heights);
        log.info("res: " + res);
    }

}
