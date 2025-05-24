class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        int m = nums1.length;
        int n = nums2.length;
        int[] nextbig = new int[m];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums2[i]) {
                s.pop();
            }

            if (s.empty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], s.peek());
            }

            s.push(nums2[i]);
        }

        for (int i = 0; i < m; i++) {
            nextbig[i] = map.get(nums1[i]);
        }

        return nextbig;
    }
}
