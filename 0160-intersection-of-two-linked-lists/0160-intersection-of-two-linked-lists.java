/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode t1 = headA;
        ListNode t2 = headB;

        while (t1 != t2) {
            t1 = t1 == null ? headB : t1.next;
            t2 = t2 == null ? headA : t2.next;
        }

        return t1;

        // solution 2 using map
        /*
         * Map<ListNode, Integer> map = new HashMap<>();
         * ListNode temp = headA;
         * while(temp != null){
         * map.put(temp, 1);
         * temp = temp.next;
         * }
         * 
         * temp = headB;
         * 
         * while(temp != null){
         * if(map.containsKey(temp)) return temp;
         * temp = temp.next;
         * }
         * return null;
         */
    }
}