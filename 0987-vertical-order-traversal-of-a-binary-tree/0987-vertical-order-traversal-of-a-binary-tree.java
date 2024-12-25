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

    class Tuple{
        TreeNode node;
        int row;
        int col;
        Tuple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        while(!queue.isEmpty()){
            TreeNode node = queue.peek().node;
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.remove();

            if(!map.containsKey(row)) map.put(row, new TreeMap<>());
            if(!map.get(row).containsKey(col)) map.get(row).put(col, new PriorityQueue<>());

            map.get(row).get(col).add(node.val);

            if(node.left != null) queue.add(new Tuple(node.left, row -1, col + 1));
            if(node.right != null) queue.add(new Tuple(node.right, row + 1, col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> element : map.values()){
            result.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : element.values()){
                while(!pq.isEmpty())
                    result.get(result.size() - 1).add(pq.poll());
            } 
        }
        return result;
    }
}