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
    int maxDepth(TreeNode root) {
       if(root == null) return 0;
       int leftD = 1 + maxDepth(root.left);
       int rightD =  1 + maxDepth(root.right);
       return Math.max(leftD, rightD);
    }
}