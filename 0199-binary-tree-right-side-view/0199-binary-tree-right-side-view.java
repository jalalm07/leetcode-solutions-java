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
    public List<Integer> rightSideView(TreeNode root) {
       
       //solution
       List<Integer> result = new ArrayList<Integer>();
       rightView(root, result, 0);
       
       
       /*
       
       Solution using level order traversal


        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i< levelSize; i++){
                TreeNode curr = queue.remove();
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);  
                if((i+1) == levelSize)
                    result.add(curr.val);
            }
        } 
        return result;  */
        return result;
    }

    public void rightView(TreeNode node, List<Integer> result, int level){
        if(node == null) return;
        if(result.size() == level) result.add(node.val);
        rightView(node.right, result, level+1);
        rightView(node.left, result, level+1);
    }
}