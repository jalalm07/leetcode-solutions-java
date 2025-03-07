/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private static int maxL = Integer.MIN_VALUE;
    private static int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, List<Integer>> leafNode = new HashMap<>();
        dfs(root, 0, leafNode);
        int maxDepth = Collections.max(leafNode.keySet());
        return leafNode.get(maxDepth)
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void dfs(TreeNode root, int level, Map<Integer, List<Integer>> leafNode) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            leafNode.computeIfAbsent(level, p -> new ArrayList<>()).add(root.val);
            return;
        }
        dfs(root.left, level + 1, leafNode);
        dfs(root.right, level + 1, leafNode);
    }
}