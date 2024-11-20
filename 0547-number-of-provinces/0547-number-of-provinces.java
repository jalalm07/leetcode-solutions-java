class Solution {

    public int findCircleNum(int[][] isConnected) {
       int[] vis = new int[isConnected.length];
       int count = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(vis[i] == 0){
                dfs(i, vis, isConnected);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, int[] vis, int[][] isConnected) {
       vis[i] = 1;
       for(int j = 0; j < isConnected[i].length; j++){
            if(vis[j] == 0 && isConnected[i][j] == 1){
                dfs(j, vis, isConnected);
            }
       }
    }
}