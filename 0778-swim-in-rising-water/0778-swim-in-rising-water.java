class Solution {
    public int swimInWater(int[][] grid) {
        int time = 0;
        int n = grid.length;
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n*n-1)){
            set.clear();
            dfs(grid, 0, 0, time, set);
            time++;
        }
        return time - 1;
    }
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    private void dfs(int[][] grid, int i, int j, int time, Set<Integer> set){
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || 
                grid[i][j] > time || set.contains(i*grid.length+j)) 
        return;
        set.add(i*grid.length+j);
        for(int[] d: directions){
            dfs(grid, i + d[0], j + d[1], time, set);
        }
    }
}