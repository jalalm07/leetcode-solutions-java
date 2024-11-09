class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        ArrayList<ArrayList<Integer>> adjL = new ArrayList<ArrayList<Integer>>();
        for(int i =0; i < isConnected.length; i++){
            adjL.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected.length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjL.get(i).add(j);
                    adjL.get(j).add(i);
                }
            }
        }

        for(int i =0; i < isConnected.length; i++){
            if(visited[i] != 1){
                count++;
                dfs(adjL, visited, i);
            }
        }
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adjL, int[] visited, int i){
        visited[i] = 1;
        for(int node : adjL.get(i)){
            if(visited[node] == 0){
                dfs(adjL, visited, node);
            }
        }
    }
}