class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for(int i = n - 2 ; i >= 0 ; i--){
            if(nums[i] < nums[i + 1]){
                pivot = i;
                break;
            }
        }

        if(pivot == -1){
            reverse(nums , 0 , n - 1);
            return;
        }
        
        else {
            for(int i = n - 1 ; i > pivot ; i++){
                if(nums[i] > nums[pivot]){
                    swap(nums , i , pivot);
                    break;
                }
            }
        }
    }
    public void reverse(int[] nums, int start , int end){
        while(start < end){
            swap(nums , start++ , end--);
        }
    }
    public void swap(int[] arr , int a , int b){
        int t = arr[a]; 
        arr[a] = arr[b];
        arr[b] = t;
    }
}
