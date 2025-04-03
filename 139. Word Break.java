import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // dp[i] represents if s[0...i-1] can be segmented
        dp[0] = true; // Empty string is always valid

        Set<String> wordSet = new HashSet<>(wordDict); // Convert list to set for O(1) lookup

        for (int i = 1; i <= n; i++) { // Iterate over the length of the string
            for (int j = 0; j < i; j++) { // Try every possible substring
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid split
                }
            }
        }
        return dp[n]; // Return if the whole string can be segmented
    }
}
