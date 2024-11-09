class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
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
            if(!visited[i]){
                count++;
                dfs(adjL, visited, i);
            }
        }
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adjL, boolean[] visited, int i){
        visited[i] = true;
        for(int node : adjL.get(i)){
            if(!visited[node]){
                dfs(adjL, visited, node);
            }
        }
    }
}