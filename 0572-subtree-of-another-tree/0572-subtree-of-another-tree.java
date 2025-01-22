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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        while(!queue.isEmpty()){
            node = queue.remove();
            if(node.val == subRoot.val) {
                if(isSame(node, subRoot)) return true;
            }
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return false;//isSame(node, subRoot);        
    }

    private boolean isSame(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}