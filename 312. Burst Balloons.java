class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length; 
        int balloons[] = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for(int i = 0 ; i < n ; i++){
            balloons[i + 1] = nums[i];
        }

        int dp[][] = new int[n + 2][n + 2];
        for(int l = 2 ; l <= n + 1 ; l++){
            for(int left = 0 ; left <= n - l + 1 ; left++){
                int right = l + left;
                for(int i = left + 1 ; i < right ; i++){
                    int coins = balloons[left] * balloons[i] * balloons[right];
                    coins += dp[left][i] + dp[i][right];
                    dp[left][right] = Math.max(dp[left][right] , coins);
                }
            }
        }
        return dp[0][n + 1];
    }
}
