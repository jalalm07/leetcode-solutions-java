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
    int result = 0;
    public int goodNodes(TreeNode root) {
        //Stack<Integer> stack = new Stack<>();
        int maxSoFar = Integer.MIN_VALUE;
        //stack.push(root.val);
        dfs(root, maxSoFar);
        return result;
    }

    private void dfs(TreeNode root, int max){
        if(root == null){
            return;
        }
        if(root.val >= max){
            result++;
            max = Math.max(root.val, max);
        }
        dfs(root.left, max);
        dfs(root.right, max);
        max = Math.max(root.val, max);
    }

    // private void dfs(TreeNode root, Stack<Integer> stack){
    //     if(root == null){
    //         return;
    //     }
    //     if(root.val >= stack.peek()){
    //         result++;
    //         stack.push(root.val);
    //     }
    //     dfs(root.left, stack);
    //     dfs(root.right, stack);
    //     if(stack.peek() == root.val) stack.pop();
    // }
}