class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length; 
        int s = matrix[0][0];
        int e = matrix[n - 1][n - 1];
        while(s <= e){
            int m = (s + e) / 2;
            int count = helper(matrix , m , n);
            if(count < k ){
                s = m + 1 ;
            }
            else{
                e = m - 1;
            }
            
        }
        return s;
    }
        public int helper(int[][] mat , int mid, int n){
            int count = 0 ; 
            int r = n - 1;
            int c = 0 ;  
            while(r >= 0 && c < n){
                if(mat[r][c] <= mid){
                    count = count + r + 1;
                    c++;
                }
                else{
                    r--;
                }
            }
            return count; 
        }
    }
