class Solution {
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] vis = new int[rows][cols];

        for (int i = 0; i < cols; i++) {
            if (vis[0][i] != 1 && board[0][i] == 'O') {
                dfs(board, vis, 0, i, rows, cols);
            }
            if (vis[rows - 1][i] != 1 && board[rows - 1][i] == 'O') {
                dfs(board, vis, rows - 1, i, rows, cols);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (vis[i][0] != 1 && board[i][0] == 'O') {
                dfs(board, vis, i, 0, rows, cols);
            }
            if (vis[i][cols - 1] != 1 && board[i][cols - 1] == 'O') {
                dfs(board, vis, i, cols - 1, rows, cols);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int[][] vis, int r, int c, int rows, int cols) {
        vis[r][c] = 1;
        for (int[] d : directions) {
            int nrow = r + d[0];
            int ncol = c + d[1];
            if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && vis[nrow][ncol] != 1
                    && board[nrow][ncol] == 'O') {
                dfs(board, vis, nrow, ncol, rows, cols);
            }
        }
    }
}