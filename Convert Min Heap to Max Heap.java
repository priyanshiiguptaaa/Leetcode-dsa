class Solution {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        for(int i = (n - 2) / 2 ; i >= 0 ; i--){
            maxheapify(nums , n , i);
        }

        return nums;
    }

    public void maxheapify(int[] nums , int n , int i){
        int large = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2;        
        if(nums[left] < n && nums[left] > nums[i]){
            large = left;
        }
        if(nums[right] < n && nums[right] > nums[i]){
            large = right;
        }
        if(large != i){
            int temp = nums[i];
            nums[i] = nums[large];
            nums[large] = temp;
            maxheapify(nums , n , large);
        }

        
    }
}
