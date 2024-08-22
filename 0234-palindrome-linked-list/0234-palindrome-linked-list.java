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
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) return true;

        //find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow);
        ListNode first = head;
        ListNode second = newHead;

        while(second != null){
            if(first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head ){
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head.next;

        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = temp;
            if(temp != null) temp = temp.next;
        }
        head = prev;
        return head;

    }
}