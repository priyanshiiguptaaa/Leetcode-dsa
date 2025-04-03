class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }    
}

//or

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            dp[i] = dp[i / 2] + (i % 2);
        }
        return dp;
    }    
}

// or


class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            String s = Integer.toBinaryString(i);
            int count = 0;
            for(int j = 0 ; j < s.length() ; j++){
                if (s.charAt(j) == '1'){
                    count++;
                }
            }
            dp[i] = count;
        }
        return dp;
    }    
}
