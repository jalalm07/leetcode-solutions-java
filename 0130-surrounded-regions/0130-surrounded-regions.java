class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for(int j = 0; j < n; j++){
            if(vis[0][j] != 1 && board[0][j] == 'O'){
                dfs(0, j, vis, board, m, n, dRow, dCol);
            }

            if(vis[m -1][j] != 1 && board[m - 1][j] == 'O'){
                dfs(m-1, j, vis, board, m, n, dRow, dCol);
            }
        }

        for(int i = 0; i < m; i++){
            if(vis[i][0] != 1 && board[i][0] == 'O'){
                dfs(i, 0, vis, board, m, n, dRow, dCol);
            }

            if(vis[i][n-1] != 1 && board[i][n -1] == 'O'){
                dfs(i, n -1, vis, board, m, n, dRow, dCol);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if(vis[i][j] != 1 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int r, int c, int[][] vis, char[][] board, int m, int n, int[] dRow, int[] dCol){
        vis[r][c] = 1;
        for (int i = 0; i < 4; i++) {
           int nRow = r + dRow[i];
           int nCol = c + dCol[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol]!=1 && board[nRow][nCol] == 'O' ) {
                dfs(nRow, nCol, vis, board, m, n, dRow, dCol);
            }
        }
    }
}