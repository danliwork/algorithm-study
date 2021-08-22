package dp;

import java.util.Arrays;


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 *
 */
public class CoinChange {

    //my solution

    public static int coinChange(int[] coins, int amount) {
        //edge cases
        if(coins == null || coins.length == 0 || amount <= 0) return -1;
        //main
        //dp[i] : min coins to get amount i
        //dp[i] = Math.min(dp[i-2], dp[i-5], ...,  dp[i-n]) + 1

        // how to handle can not form amount????
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            System.out.println("Current amount=" + i);

            int min = amount + 1;
            for(int c : coins){
                if((c < i && dp[i-c] > 0) || c==i){
                    min = Math.min(min, dp[i-c]);
                    dp[i] = min +1;
                    System.out.println("DP[i]=" + dp[i]);

                }
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        int[] arr = { 2 };
        //Arrays.stream(arr).forEach(s -> System.out.print(s + ", "));
        coinChange(arr, 3);
    }
}
