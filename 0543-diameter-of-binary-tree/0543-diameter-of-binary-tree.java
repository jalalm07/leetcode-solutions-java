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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        height(root);
        return diameter;
    }

    int height(TreeNode node){
        if(node == null)
            return 0;
        int heightLeft = height(node.left);
        int heightRight = height(node.right);
        int dia = heightLeft + heightRight;
        diameter = Math.max(dia, diameter);
        return Math.max(heightLeft, heightRight) + 1;
    }
}