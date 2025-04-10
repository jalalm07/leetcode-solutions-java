class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= edges.length; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            boolean[] visited = new boolean[edges.length + 1];
            int u = edge[0];
            int v= edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            if(dfs(u, -1, adjList, visited)){
                return edge;
            }
        }
        return new int[2];
    }

    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adjList, boolean[] visited){
        if(visited[node]) return true;
        visited[node] = true;
        for(int adj: adjList.get(node)){
            if(adj == parent) continue;
            if(dfs(adj, node, adjList, visited)) return true;
        }
        return false;
    }
}