class Solution {

    class pair {
        int row;
        int col;
        int t;
        public pair(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<pair> queue = new LinkedList<>();
        int cntFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.add(new pair(i,j,0));
                    vis[i][j] = 2;
                }
                else if(grid[i][j] == 1) cntFresh++;
            }
        }

        int cnt = 0;
        int tm = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().t;
            tm = Math.max(t, tm);
            queue.remove();
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 2;
                    queue.add(new pair(nrow, ncol, t + 1));
                    cnt++;
                }
            }
        }

        if(cnt != cntFresh) return -1;
        return tm;
    }
}