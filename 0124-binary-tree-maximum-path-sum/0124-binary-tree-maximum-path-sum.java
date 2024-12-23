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
    int maxSum = Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode root){
        if(root == null) return 0;
        int leftSum = maxSum(root.left);
        int rightSum = maxSum(root.right);
        leftSum = Math.max(0, leftSum);
        rightSum = Math.max(0, rightSum);
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return Math.max(leftSum , rightSum) + root.val;
    }

}