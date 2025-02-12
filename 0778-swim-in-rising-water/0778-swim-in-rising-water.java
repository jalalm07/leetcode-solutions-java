class Solution {

    public int swimInWater(int[][] grid) {
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { grid[0][0], 0, 0 });
        vis[0][0] = true;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int max = curr[0];
            int r = curr[1];
            int c = curr[2];
            if (r == n - 1 && c == n - 1) {
                return max;
            }

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    pq.offer(new int[] { Math.max(max, grid[nr][nc]), nr, nc });
                }
            }
        }
        return -1;
    }
    // dfs
    /*
     * public int swimInWater(int[][] grid) {
     * int time = 0;
     * int n = grid.length;
     * Set<Integer> set = new HashSet<>();
     * while(!set.contains(n*n-1)){
     * set.clear();
     * dfs(grid, 0, 0, time, set);
     * time++;
     * }
     * return time - 1;
     * }
     * int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
     * private void dfs(int[][] grid, int i, int j, int time, Set<Integer> set){
     * if(i < 0 || i > grid.length - 1 || j < 0 || j > grid.length - 1 ||
     * grid[i][j] > time || set.contains(i*grid.length+j))
     * return;
     * set.add(i*grid.length+j);
     * for(int[] d: directions){
     * dfs(grid, i + d[0], j + d[1], time, set);
     * }
     * }
     */
}