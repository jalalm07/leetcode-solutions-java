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
    int count = 0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode root, int k){
        if(root == null) return;
        inorder(root.left, k);
        count++;
        if(count == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }

    //brute force solution below
    /*
    public int kthSmallest(TreeNode root, int k) {
        populateStack(root);
        TreeNode temp = root;
        while( k != 0){
            //remove the kth smallest elements from the queue.
            temp = queue.remove();
            k--;
        }
        return temp.val;
    }

    TreeNode populateStack(TreeNode root){
        //in-order traversal, adding items in queue in asscending order
        if(root == null)
            return null;
        populateStack(root.left);
        queue.add(root);
        populateStack(root.right); 
        return root;
    }
    */
}