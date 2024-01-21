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
    public int kthSmallest(TreeNode root, int k) {
        return findKthSmallest(root, k).val;
    }

    TreeNode findKthSmallest(TreeNode node, int k){
        if(node == null)
            return null;

        TreeNode left =   findKthSmallest(node.left, k);
        if(left != null) 
            return left;
        count++;
        if(count == k)
            return node;
        return findKthSmallest(node.right, k);
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