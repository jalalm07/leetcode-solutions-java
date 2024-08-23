/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        ListNode mid = findMid(head);
        ListNode rightL = mid.next;
        mid.next = null;
        ListNode leftL = head;
        ListNode left = sortList(leftL);
        ListNode right = sortList(rightL);
        return mergeList(left, right);
    }

    static ListNode findMid(ListNode head){
       ListNode slow = head;
       ListNode fast = head.next;
       while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
       }
       return slow;
    }

    static ListNode mergeList(ListNode head1, ListNode head2){
        ListNode newList = new ListNode();
        ListNode temp = newList;
        while(head1 != null && head2 !=null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        temp.next = (head1 != null) ? head1 : head2;
        return newList.next;
    }
}