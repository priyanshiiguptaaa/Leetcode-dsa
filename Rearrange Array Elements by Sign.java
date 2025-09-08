class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int num : nums) {
            if (num > 0)
                positive.add(num);
            else
                negative.add(num);
        }

        int[] result = new int[nums.length];
        int p = 0, n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                result[i] = positive.get(p++);
            else
                result[i] = negative.get(n++);
        }
        
        return result;
    }
}
