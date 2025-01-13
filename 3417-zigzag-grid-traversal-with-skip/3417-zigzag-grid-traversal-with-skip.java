class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        boolean rev = false;
        for (int i = 0; i < grid.length; i++) {
            if (!rev) {
                for (int j = 0; j < grid[0].length; j++) {
                    if ((i + j) % 2 == 0) {
                        ans.add(grid[i][j]);
                    }
                }
                rev = !rev;
            } else {
                for (int j = grid[0].length -1; j > 0; j--) {
                    if ((i + j) % 2 == 0) {
                        ans.add(grid[i][j]);
                    }
                }
                rev = !rev;
            }

        }
        return ans;
    }
}