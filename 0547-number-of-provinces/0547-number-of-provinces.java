class Solution {
    private int[][] adj;
    private boolean[] vis;

    public int findCircleNum(int[][] isConnected) {
        adj = isConnected;
        int n = adj.length;
        vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int i) {
        vis[i] = true;
        for (int j = 0; j < adj.length; j++) {
            if (!vis[j] && adj[i][j] == 1) {
                dfs(j);
            }
        }
    }
}