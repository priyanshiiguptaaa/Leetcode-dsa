class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev1 = cost[n - 1];
        int prev2 = cost[n - 2];
        
        for (int i = n - 3; i >= 0; i--) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev1 = prev2;
            prev2 = curr;
        }
        
        return Math.min(prev1, prev2);
    }
}
