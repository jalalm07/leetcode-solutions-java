class Solution {
    class Pair{
        int r;
        int c;
        int step;
        public Pair(int r, int c, int step){
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n]; 
        int[][] vis = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int row = queue.peek().r;
            int col = queue.peek().c;
            int step = queue.peek().step;
            queue.remove();
            res[row][col] = step;
            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0){
                    queue.add(new Pair(nrow, ncol, step+1));
                    vis[nrow][ncol] = 1;
                }
            }
        }

        return res;

    }
}