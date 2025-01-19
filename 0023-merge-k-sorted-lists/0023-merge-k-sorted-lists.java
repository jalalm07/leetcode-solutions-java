/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                nodes.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(nodes);

        ListNode res = new ListNode(0);
        ListNode curr = res;
        for (int node : nodes) {
            curr.next = new ListNode(node);
            curr = curr.next;
        }
        return res.next;
    }
}