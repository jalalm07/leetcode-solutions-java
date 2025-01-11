class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int rw = 0;
        int cl = matrix[0].length - 1;

        while (rw < m && cl >= 0) {
            if (target < matrix[rw][cl]) {
                cl--;
            } else if (target > matrix[rw][cl]) {
                rw++;
            } else
                return true;
        }
        return false;
    }
}