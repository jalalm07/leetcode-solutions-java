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

        if(lists.length == 0) return null;

        for(int i = 1; i < lists.length; i++){
            lists[i] = merge(lists[i], lists[i - 1]);
        }

        return lists[lists.length - 1];
/*
        if (lists.length == 0) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;

            node = node.next;
            if (node != null) {
                minHeap.offer(node);
            }
        }
        return res.next;
*/


        // List<Integer> nodes = new ArrayList<>();
        // for (ListNode list : lists) {
        //     while (list != null) {
        //         nodes.add(list.val);
        //         list = list.next;
        //     }
        // }

        // Collections.sort(nodes);

        // ListNode res = new ListNode(0);
        // ListNode curr = res;
        // for (int node : nodes) {
        //     curr.next = new ListNode(node);
        //     curr = curr.next;
        // }
        // return res.next;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}