class Solution {
public void heapify(int[] nums , int n ,  int i){
    int max = i; 
    int left = 2*i+1; 
    int right = 2*i+2;
    if(left < n && nums[left] > nums[max]){
        max = left;
    }
    if(right < n && nums[right] > nums[max]){
        max = right;
    }

    if(max != i){
        int swap = nums[i];
        nums[i] = nums[max];
        nums[max] = swap;
        heapify(nums , n ,  max);
    }
}

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i = n / 2 ; i >= 0 ; i--){
            heapify(nums , n , i);
        }

        for(int i = n - 1 ; i >= 0 ; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums , i ,  0);
        }
        return nums;
    }
}
