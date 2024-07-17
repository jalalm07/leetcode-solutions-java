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

class Pair {
    int num;
    TreeNode node;

    Pair(int num, TreeNode node) {
        this.num = num;
        this.node = node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int maxWidth = 0;

        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().num;
            int firstIndex = 0, lastIndex = 0;

            for (int i = 0; i < size; i++) {
                int curIndex = queue.peek().num - minIndex; // Adjust index to prevent overflow
                TreeNode node = queue.poll().node;
                if (i == 0)
                    firstIndex = curIndex;
                if (i == size - 1)
                    lastIndex = curIndex;
                if (node.left != null)
                    queue.offer(new Pair(curIndex * 2 + 1, node.left));
                if (node.right != null)
                    queue.offer(new Pair(curIndex * 2 + 2, node.right));
            }
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }
        return maxWidth;
    }
}