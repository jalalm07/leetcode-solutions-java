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
class FindElements {

    TreeNode root;
    Set<Integer> set;
    public FindElements(TreeNode root) {
       //root = root;
       set = new HashSet<>();
       root.val = 0;
       set.add(0);
       recover(root);
    }

    private void recover(TreeNode root){
        if(root.left == null && root.right == null) return;
        if(root.left != null){
            root.left.val = 2 * root.val + 1;
            set.add(root.left.val);
            recover(root.left);
        }
        if(root.right != null){
            root.right.val = 2 * root.val + 2;
            set.add(root.right.val);
            recover(root.right);
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */