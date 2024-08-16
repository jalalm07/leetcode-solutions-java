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
    
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root,root,k);
    }
    public boolean dfs(TreeNode current, TreeNode root, int sum){
        if(current == null) return false;

        int compliment = sum-current.val;
        if(search(root,current,compliment)){
            return true;
        }
        return dfs(current.left,root,sum) || dfs(current.right,root,sum);
    }
    public boolean search(TreeNode root, TreeNode exclude, int target){
        if(root == null) return false;

        if(root.val == target && root == exclude) return false;
        if(root.val == target) return true;
        if(root.val>target) return search(root.left,exclude,target);
        return search(root.right,exclude,target);
    }
}