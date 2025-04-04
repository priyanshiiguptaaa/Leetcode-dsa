import java.util.Arrays;

class Solution {
    public int numTrees(int n) {
        if (n == 0) return 1; 
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);  // Initialize dp array with -1 to indicate uncomputed values
        dp[0] = 1;  // Base case: 1 tree for 0 nodes (empty tree)
        dp[1] = 1;  // Base case: 1 tree for 1 node
        
        return help(n, dp);
    }

    public int help(int n, int[] dp) {
        // If the result is already computed, return it
        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        // Calculate the number of unique BSTs for `n` nodes by considering all possible roots
        for (int i = 1; i <= n; i++) {
            // For each root `i`, the left subtree has `i-1` nodes and the right subtree has `n-i` nodes
            ans += help(i - 1, dp) * help(n - i, dp);
        }

        // Store the computed result in the dp array
        dp[n] = ans;
        return ans;
    }
}
