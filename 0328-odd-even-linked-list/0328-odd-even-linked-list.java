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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyOdd = head;
        ListNode dummyEven = head.next;
        ListNode dummyEvenTemp = dummyEven;

        while(dummyEvenTemp != null && dummyEvenTemp.next != null && dummyOdd.next!= null){
           dummyOdd.next = dummyOdd.next.next;
           dummyEvenTemp.next = dummyEvenTemp.next.next;
           dummyOdd = dummyOdd.next;
           dummyEvenTemp = dummyEvenTemp.next;
        }
        dummyOdd.next = dummyEven;
        return head;
    }
}