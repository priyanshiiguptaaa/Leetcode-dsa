import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts); // Sort the cuts for proper segmentation

        // Extend the cuts array with 0 and n
        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        newCuts[m + 1] = n;
        System.arraycopy(cuts, 0, newCuts, 1, m);

        // Memoization table
        int[][] dp = new int[m + 2][m + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return cost(0, m + 1, newCuts, dp);
    }

    private int cost(int left, int right, int[] cuts, int[][] dp) {
        if (right - left == 1) return 0; // No more cuts possible

        if (dp[left][right] != -1) return dp[left][right]; // Return precomputed result

        int minCost = Integer.MAX_VALUE;
        for (int k = left + 1; k < right; k++) {
            int curCost = (cuts[right] - cuts[left]) + cost(left, k, cuts, dp) + cost(k, right, cuts, dp);
            minCost = Math.min(minCost, curCost);
        }

        return dp[left][right] = minCost;
    }
}
