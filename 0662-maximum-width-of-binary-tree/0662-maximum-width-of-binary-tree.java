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

class Pair{
    int num;
    TreeNode node;
    Pair(int num, TreeNode node){
        this.num = num;
        this.node = node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(0, root));
        while(!queue.isEmpty()){
            int size = queue.size();
            int first = 0;
            int last = 0; 
            int min = queue.peek().num;
            for(int i = 0; i < size; i++){
                int curIndex = queue.peek().num;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i==0) first = curIndex;
                if(i == size - 1) last = curIndex;
                if(node.left!=null) queue.offer(new Pair(curIndex*2+1, node.left));
                if(node.right!=null) queue.offer(new Pair(curIndex*2+2, node.right));  
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;    
    }
}