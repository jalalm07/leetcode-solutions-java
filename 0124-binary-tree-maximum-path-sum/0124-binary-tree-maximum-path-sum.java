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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        //this is to ignore any negative left sum or right sum
        leftSum = Math.max(0, leftSum);
        rightSum = Math.max(0, rightSum);


        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}