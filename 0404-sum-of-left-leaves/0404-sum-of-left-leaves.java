/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return sum;
    }

    private void dfs(TreeNode root, boolean isLeft){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && isLeft){
            sum += root.val;
            return;
        }
        dfs(root.left, true);
        dfs(root.right, false);
    }
}