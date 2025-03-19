import java.util.*;
public class Solution {
    public static int maxProfitHelper(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w, int[][] dp) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (weights.get(n - 1) <= w) {
            int ans1 = values.get(n - 1) + maxProfitHelper(values, weights, n - 1, w - weights.get(n - 1), dp);
            int ans2 = maxProfitHelper(values, weights, n - 1, w, dp); 
            dp[n][w] = Math.max(ans1, ans2);
        } else { 
            dp[n][w] = maxProfitHelper(values, weights, n - 1, w, dp);
        }

        return dp[n][w];
    }

    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxProfitHelper(values, weights, n, w, dp);
    }
}
