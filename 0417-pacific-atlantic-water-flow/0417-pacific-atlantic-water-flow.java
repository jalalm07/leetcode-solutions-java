class Solution {
        private int[][] directions = {{1, 0}, {-1, 0}, 
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            dfs(heights, 0, i, pac);
            dfs(heights, m - 1, i, atl);
        }

        for(int i = 0; i < m; i++){
            dfs(heights, i, 0, pac);
            dfs(heights, i, n - 1, atl);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && atl[i][j]){
                    result.add(Arrays.asList(i, j));                   
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] ocean){
        ocean[i][j] = true;
        for(int[] d: directions){
            int nrow = i + d[0];
            int ncol = j + d[1];
            if(nrow >= 0 && nrow < heights.length && ncol >= 0 && ncol < heights[0].length &&
                !ocean[nrow][ncol] && heights[nrow][ncol] >= heights[i][j]){
                    dfs(heights, nrow, ncol, ocean);
            }
        }
    }
}