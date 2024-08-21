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
        ListNode dummyOddTemp = dummyOdd;
        ListNode dummyEvenTemp = dummyEven;

        while(dummyEvenTemp != null && dummyEvenTemp.next != null && dummyOddTemp.next!= null){
           dummyOddTemp.next = dummyOddTemp.next.next;
           dummyEvenTemp.next = dummyEvenTemp.next.next;
           dummyOddTemp = dummyOddTemp.next;
           dummyEvenTemp = dummyEvenTemp.next;
        }
        dummyOddTemp.next = dummyEven;
        return head;
    }
}