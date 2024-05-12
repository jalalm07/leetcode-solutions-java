class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
         for (int i = 0; i < m - 1; i++) {
            if (!Arrays.equals(grid[i], grid[i + 1])) {
                return false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}