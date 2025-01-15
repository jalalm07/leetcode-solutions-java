/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        while(curr != null){
            Node temp = new Node(curr.val);
            map.put(curr, temp);
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            Node temp = map.get(curr);
            temp.next = map.get(curr.next);
            temp.random = curr.random == null ? null : map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}