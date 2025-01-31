class Solution {
    private int rows;
    private int cols;
    private boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        vis = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(dfs(board, vis, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] vis, String word, int row, int col, int i){
        if(i == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row >= rows || col >= cols || vis[row][col] || board[row][col] != word.charAt(i)){
            return false;
        }

        vis[row][col] = true;
        boolean result = dfs(board, vis, word, row, col + 1, i + 1) || 
                        dfs(board, vis, word, row + 1, col, i + 1) || 
                        dfs(board, vis, word, row, col - 1, i + 1) || 
                        dfs(board, vis, word, row - 1, col, i + 1);
        vis[row][col] = false;
        return result;
    }
}