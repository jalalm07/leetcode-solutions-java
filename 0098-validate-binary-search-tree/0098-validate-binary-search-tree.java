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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return false;
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);    
    }

    boolean isBST(TreeNode root, int minVal, int maxVal){
       if(root == null) return true;
       if(root.val >= maxVal || root.val <= minVal) return false;
       return isBST(root.left, minVal , root.val) && isBST(root.right, root.val, maxVal);
    }
}