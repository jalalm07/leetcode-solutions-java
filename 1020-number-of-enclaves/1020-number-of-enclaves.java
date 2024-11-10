class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int res = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i = 0; i < n; i++){
            if(vis[0][i]!= 1 && grid[0][i] == 1){
                dfs(0, i, vis, grid, drow, dcol, m, n);
            }

            if(vis[m -1][i]!= 1 && grid[m-1][i] == 1){
                dfs(m -1, i, vis, grid, drow, dcol, m ,n);
            }
        }

        for(int j = 0; j < m; j++){
            if(vis[j][0]!= 1 && grid[j][0] == 1){
                dfs(j, 0, vis, grid, drow, dcol, m, n);
            }

            if(vis[j][n -1]!= 1 && grid[j][n -1] == 1){
                dfs(j, n -1, vis, grid, drow, dcol, m, n);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] != 1 && grid[i][j] == 1){
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(int r, int c, int[][] vis, int[][] grid, int[] drow, int[] dcol, int m, int n){
        vis[r][c] = 1;
        for(int i =0; i < 4; i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow >=0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] != 1 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, vis, grid, drow, dcol, m, n);
            }
        }
    }
}