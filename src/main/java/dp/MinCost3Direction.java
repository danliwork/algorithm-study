package dp;

import lombok.extern.slf4j.Slf4j;

/*
Min Cost Path | DP-6
Difficulty Level : Easy
 Last Updated : 05 Jan, 2021

Given a cost matrix cost[][] and a position (m, n) in cost[][],
write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
Each cell of the matrix represents a cost to traverse through that cell.
The total cost of a path to reach (m, n) is the sum of all the costs on that path (including both source and destination).
You can only traverse down, right and diagonally lower cells from a given cell,
i.e., from a given cell (i, j), cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed.
You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?
 */
@Slf4j
public class MinCost3Direction {
    //TC=M*n   space = m*n
    // dp[i][j] = min cost that reach m[i][j]
    //dp [i][j]  = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + matrix[i][j]
    public static int minCost(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c];
        //base case
        dp[0][0] = matrix[0][0];
        //ERROR need to initialize first row and column
        //first row
        for(int i=1; i<c; i++){
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        //first col
        for(int i=1; i<r; i++){
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }

        // transition
        for(int i = 1; i<r; i++){
            for(int j = 1; j<c; j++){
                dp [i][j]  = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + matrix[i][j];
            }
        }
        return dp[r-1][c-1];
    }

    public static void main(String[] args) {
        int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
        log.info("MinCost={}", minCost(cost));
    }
}
