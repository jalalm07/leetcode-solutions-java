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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode temp = dummyNode;
        int carry = 0;

         while(l1 != null || l2 != null) {
            int sum = carry;
            if(l1!=null) sum += l1.val;
            if(l2!=null) sum += l2.val;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = newNode;
            temp = temp.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        if(carry != 0){
            ListNode node = new ListNode(carry);
            temp.next = node;
        }
        return dummyNode.next;
    }
}