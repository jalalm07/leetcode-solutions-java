/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

   
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        if(root == null) return "";
        while(!queue.isEmpty()){
            
                TreeNode node = queue.remove();
                if(node != null){
                         sb.append(node.val+",");
                    queue.add(node.left);
                    queue.add(node.right);
                }else sb.append("#,");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(!arr[index].equals("#")){
                TreeNode nodeL = new TreeNode(Integer.parseInt(arr[index]));
                node.left = nodeL;
                queue.add(nodeL);
            }
            index++;
            if(!arr[index].equals("#")){
                TreeNode nodeR = new TreeNode(Integer.parseInt(arr[index]));
                node.right = nodeR;
                queue.add(nodeR);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));