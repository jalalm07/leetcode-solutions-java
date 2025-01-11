class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r =   m * n - 1;

        while(l <= r){
            int mid = (l + r) /2;
            int row = mid / n;
            int col = mid % n;
            if(target == matrix[row][col]){
                return true;
            } else if(target > matrix[row][col]){
                l = mid + 1;
            } else r = mid - 1;
        }  
        

        // while (rw < m && cl >= 0) {
        //     if (target < matrix[rw][cl]) {
        //         cl--;
        //     } else if (target > matrix[rw][cl]) {
        //         rw++;
        //     } else
        //         return true;
        // }
        return false;
    }
}