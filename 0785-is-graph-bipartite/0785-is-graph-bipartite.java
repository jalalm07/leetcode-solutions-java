class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;
        int[] vis = new int[m];
        for (int i = 0; i < m; i++) {
            if (vis[i] != 0)
                continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            vis[i] = 1;
            while (!queue.isEmpty()) {
                int node = queue.remove();
                for (int adjV : graph[node]) {
                    if (vis[adjV] == 0) {
                        vis[adjV] = vis[node] == 1 ? 2 : 1;
                        queue.add(adjV);
                    } else if (vis[adjV] == vis[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}