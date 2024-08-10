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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null)
            return newNode;
        TreeNode curr = root;
        while (true) {
            if (curr.val > val) {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = newNode;
                    break;
                }
            } else {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = newNode;
                    break;
                }
            }
        }
        return root;
    }
}