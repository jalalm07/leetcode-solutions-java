class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] != 1 && grid[i][j] == 1){
                    dfs(grid, vis, i, j, m, n);
                    ans = Math.max(max, ans);
                    max = 0;
                }
            }
        }
        return ans; 
    }

    private void dfs(int[][] grid, int[][] vis, int i, int j, int m, int n){
        if(i>= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1 && vis[i][j] != 1){
            vis[i][j] = 1;
            max++;
            dfs(grid, vis, i + 1, j, m, n);
            dfs(grid, vis, i - 1, j, m, n);
            dfs(grid, vis, i, j + 1, m, n);
            dfs(grid, vis, i, j - 1, m, n);
        }
    }
}