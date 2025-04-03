import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // Step 1: Create a sorted unique array using HashMap
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        // Remove duplicates using HashMap
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int newIndex = 0;
        for (int num : sorted) {
            if (!indexMap.containsKey(num)) {  // Store unique elements
                indexMap.put(num, newIndex++);
            }
        }

        // Step 2: Create a mapped version of nums using unique indices
        int[] mappedNums = new int[n];
        for (int i = 0; i < n; i++) {
            mappedNums[i] = indexMap.get(nums[i]);
        }

        // Step 3: Compute LCS using 1D DP optimization
        return lcs(mappedNums, newIndex);
    }

    public int lcs(int[] a, int size) {
        int n = a.length;
        int[] prev = new int[size + 1];
        int[] curr = new int[size + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= size; j++) {
                if (a[i - 1] == j - 1) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr.clone();
        }
        return prev[size];
    }
}
