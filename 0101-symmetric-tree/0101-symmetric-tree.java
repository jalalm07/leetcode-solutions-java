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
    public boolean isSymmetric(TreeNode root) {
        
        //solution1
        if(root == null) return true;
        return isSymmetricHelper(root.left, root.right);    

        //solution 2
        // if(root == null)
        //     return false;
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root.left);
        // queue.add(root.right);
        // while(!queue.isEmpty()){
        //     TreeNode left = queue.remove();
        //     TreeNode right = queue.remove();
        //     if(left == null && right == null){
        //         continue;
        //     }   
        //     if(left == null || right == null){
        //         return false;
        //     }    
        //     if(left.val != right.val){
        //         return false;        
        //     }    
        //     queue.add(left.left);
        //     queue.add(right.right);
        //     queue.add(left.right);
        //     queue.add(right.left);
        // }
        // return true;    
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if(left == null || right == null)
            return left == right;
        if(left.val != right.val) return false;
        return isSymmetricHelper(left.left, right.right) && 
                    isSymmetricHelper(left.right, right.left);
    }
}