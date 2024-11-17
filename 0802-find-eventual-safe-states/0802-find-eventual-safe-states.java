class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;

        List<Integer> result = new ArrayList<>();
        int[] vis = new int[m];
        int[] pathVis = new int[m];
        int[] check = new int[m];

        for(int i =0; i < m; i++){
            if(vis[i] == 0) dfs(i, vis, pathVis, check, graph);
        }
        for(int i = 0; i < m; i++){
            if(check[i] == 1) result.add(i);
        }
        return result;
    }

    public boolean dfs(int node, int[] vis, int[] pathVis, int[] check, int[][] graph){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for(int adj: graph[node]){
            if(vis[adj] == 0){
                if(dfs(adj, vis, pathVis, check, graph) == true){
                    check[node] = 0; 
                    return true;
                } 
            } else if(pathVis[adj] == 1){
                check[node] = 0; 
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}