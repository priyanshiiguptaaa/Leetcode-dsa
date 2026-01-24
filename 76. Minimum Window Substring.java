class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) return "";
        int[] freq = new int[256];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        int l = 0, r = 0;
        int req = m;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (r < n) {
            char c = s.charAt(r);
            if (freq[c] > 0) {
                req--;
            }
            freq[c]--;
            r++;
            while (req == 0) {
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }

                char lc = s.charAt(l);
                freq[lc]++;
                if (freq[lc] > 0) {
                    req++;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
